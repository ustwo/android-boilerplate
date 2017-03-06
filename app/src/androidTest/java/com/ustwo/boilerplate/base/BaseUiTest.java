package com.ustwo.boilerplate.base;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.google.android.libraries.cloudtesting.screenshots.ScreenShotter;
import com.squareup.spoon.Spoon;

public class BaseUiTest {

    protected final void screenshot(@NonNull final Activity activity,
            @NonNull final String screenshotName) {
        try {
            Spoon.screenshot(activity, screenshotName);
            ScreenShotter.takeScreenshot(screenshotName, activity);
        } catch (final RuntimeException exception) {
            System.err.println("To capture screenshots run with spoon enabled");
        }
    }
}
