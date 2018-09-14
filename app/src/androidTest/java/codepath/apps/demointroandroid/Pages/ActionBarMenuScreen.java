package codepath.apps.demointroandroid.Pages;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import codepath.apps.demointroandroid.ActionBarMenuActivity;
import codepath.apps.demointroandroid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static android.support.test.espresso.Espresso.onView;

public class ActionBarMenuScreen {

    public ActionBarMenuScreen(){
        //onView(withId(R.layout.activity_action_bar_menu)).check(matches(isDisplayed()));
    }

    private ViewInteraction mainTextView = onView(withText("Try My Action Bar!"));
    private ViewInteraction toastActionBarItem = onView(withId(R.id.menu_toast));
    private ViewInteraction launchNewBundleActionBarItem = onView(withId(R.id.menu_launch));

    //simpleBundleDemoActivity elements
    private ViewInteraction mainText = onView(withId(R.id.tvDisplayText));
    private ViewInteraction bundleTitle = onView(allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("SimpleBundleDemoActivity")));

    public ViewInteraction mainTextViewIsDisplayed(){
        return mainTextView.check(matches(isDisplayed()));
    }

    public ViewInteraction toastActionBarItemIsDisplayed(){
        return toastActionBarItem.check(matches(isDisplayed()));
    }

    public ViewInteraction launchNewBundleActionBarItemIsDisplayed() {
        return launchNewBundleActionBarItem.check(matches(isDisplayed()));
    }

    public ViewInteraction launchNewBundleActionBarItemClick() {
        return launchNewBundleActionBarItem.perform(click());
    }

    public ViewInteraction validateMessageNewBundleText(String message){
        return mainText.check(matches(withText(message)));
    }

    public ViewInteraction validateMessageNewBundleIsDisplayed(){
        return mainText.check(matches(isDisplayed()));
    }

    public ViewInteraction validateBundleTitleIsDisplayed(){
        return bundleTitle.check(matches(isDisplayed()));
    }

}
