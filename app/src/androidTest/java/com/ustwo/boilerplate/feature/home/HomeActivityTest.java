package com.ustwo.boilerplate.feature.home;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.support.test.rule.ActivityTestRule;
import com.ustwo.boilerplate.R;
import com.ustwo.boilerplate.base.BaseUiTest;
import org.junit.Rule;
import org.junit.Test;

public class HomeActivityTest extends BaseUiTest {

    @Rule public ActivityTestRule<HomeActivity> activityTestRule =
            new ActivityTestRule<>(HomeActivity.class, true, true);

    @Test
    public void home_appNameShown() {
        onView(withId(R.id.textView_appName))
                .check(matches(allOf(withText(R.string.app_name), isDisplayed())));

        screenshot(activityTestRule.getActivity(), "app_name_displayed");
    }
}
