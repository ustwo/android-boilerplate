#!/bin/bash
set -e
set -x

if [ -n "${GCLOUD_SERVICE_KEY+1}" ]; then
    sudo pip install -U crcmod
    echo $GCLOUD_SERVICE_KEY > ${HOME}/client-secret.json
    
    GCLOUD=`which gcloud`

    $GCLOUD auth activate-service-account $GCLOUD_SERVICE_ACCOUNT --key-file $HOME/client-secret.json
    sudo $GCLOUD --quiet components update
    sudo $GCLOUD --quiet components install beta

    GCLOUD_OUTPUT_LOG=gcloudLog.txt

    $GCLOUD beta test android run --type instrumentation --uri --app ../app/build/outputs/apk/app-debug.apk --test ../app/build/outputs/apk/app-debug-androidTest.apk --orientations portrait --project $GCLOUD_PROJECT_ID | tee $GCLOUD_OUTPUT_LOG

    BUCKET_ID=`cat $GCLOUD_OUTPUT_LOG | sed -n -E 's#^.+test-lab-(.+)/.+#\1#p'`

    echo $BUCKET_ID

    TEST_OUTPUT_FOLDER=testResults
    mkdir $TEST_OUTPUT_FOLDER
    gsutil -m cp -R -U gs://test-lab-$BUCKET_ID $TEST_OUTPUT_FOLDER || true

    mkdir $CIRCLE_TEST_REPORTS/cloudTesting
    cp -r $TEST_OUTPUT_FOLDER $CIRCLE_TEST_REPORTS/cloudTesting

    rm $GCLOUD_OUTPUT_LOG
    rm -r $TEST_OUTPUT_FOLDER
fi
