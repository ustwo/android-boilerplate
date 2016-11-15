if [ -n "${GCLOUD_SERVICE_KEY+1}" ]; then
    sudo pip install -U crcmod
    echo $GCLOUD_SERVICE_KEY > ${HOME}/client-secret.json

    gcloud auth activate-service-account $GCLOUD_SERVICE_ACCOUNT --key-file $HOME/client-secret.json
    sudo gcloud --quiet components update
    sudo gcloud --quiet components install beta

    GCLOUD_OUTPUT_LOG=gcloudLog.txt

    gcloud beta test android run --type instrumentation --uri --app ../app/build/outputs/apk/app-debug.apk --test ../app/build/outputs/apk/app-debug-androidTest.apk --orientations portrait --project $GCLOUD_PROJECT_ID > $GCLOUD_OUTPUT_LOG 2>&1

    BUCKET_ID=`cat output.txt | sed -n -E 's#^.+test-lab-(.+)/.+#\1#p'`

    echo $BUCKET_ID

    TEST_OUTPUT_FOLDER=testResults
    mkdir $TEST_OUTPUT_FOLDER
    gsutil -m cp -R -U gs://test-lab-$BUCKET_ID $TEST_OUTPUT_FOLDER

    mkdir $CIRCLE_TEST_REPORTS/cloudTesting
    cp -r $TEST_OUTPUT_FOLDER $CIRCLE_TEST_REPORTS/cloudTesting

    rm $GCLOUD_OUTPUT_LOG
    rm -r $TEST_OUTPUT_FOLDER
fi
