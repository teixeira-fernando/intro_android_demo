
package codepath.apps.demointroandroid.Tests;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import codepath.apps.demointroandroid.DemoSelector;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    public static final String STRING_TO_BE_PRESENT = "Basic TextView";

    @Rule
    public ActivityTestRule<DemoSelector> mActivityRule = new ActivityTestRule<>(
            DemoSelector.class);

    @Test
    public void firstTest() {
        // Type text and then press the button.
        onView(withText("Chapter 1: App Fundamentals"))
                .perform(click());

        // Check that the text was changed.
        onView(withText("Basic TextView")).check(matches(withText(STRING_TO_BE_PRESENT)));

    }

}