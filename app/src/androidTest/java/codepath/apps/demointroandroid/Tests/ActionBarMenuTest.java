package codepath.apps.demointroandroid.Tests;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.EspressoKey;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;
import android.widget.Toolbar;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import codepath.apps.demointroandroid.ActionBarMenuActivity;
import codepath.apps.demointroandroid.BasicClickHandlersActivity;
import codepath.apps.demointroandroid.Pages.ActionBarMenuScreen;
import codepath.apps.demointroandroid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActionBarMenuTest {

    ActionBarMenuScreen actionBarMenuScreen;

    @Rule
    public ActivityTestRule<ActionBarMenuActivity> mActivityRule = new ActivityTestRule<>(
            ActionBarMenuActivity.class);

    @Before
    public void pageInitializer(){
        actionBarMenuScreen = new ActionBarMenuScreen();
    }

    @Test
    public void validateMainTextIsDisplayed() {
        actionBarMenuScreen.mainTextViewIsDisplayed();
        actionBarMenuScreen.toastActionBarItemIsDisplayed();
        actionBarMenuScreen.launchNewBundleActionBarItemIsDisplayed();
    }

    @Test
    public void validateLaunchNewBundle() {
        actionBarMenuScreen.launchNewBundleActionBarItemClick();
        actionBarMenuScreen.validateBundleTitleIsDisplayed();
        actionBarMenuScreen.validateMessageNewBundleIsDisplayed();
        actionBarMenuScreen.validateMessageNewBundleText("No Passed Bundle :(");
    }
}
