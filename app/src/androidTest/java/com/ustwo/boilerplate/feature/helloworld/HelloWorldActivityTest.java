package com.ustwo.boilerplate.feature.helloworld;

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

public class HelloWorldActivityTest extends BaseUiTest {

  @Rule public ActivityTestRule<HelloWorldActivity> activityTestRule =
      new ActivityTestRule<>(HelloWorldActivity.class, true, true);

  @Test
  public void helloWorld_textShown() {
    onView(withId(R.id.textView_helloWorld))
        .check(matches(allOf(withText(R.string.hello_world), isDisplayed())));

    screenshot(activityTestRule.getActivity(), "hello_world_text_displayed");
  }
}
