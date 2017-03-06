package com.ustwo.boilerplate;

import static junit.framework.Assert.assertEquals;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        final Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals(0xffffffff, ContextCompat.getColor(appContext, android.R.color.white));
    }
}
