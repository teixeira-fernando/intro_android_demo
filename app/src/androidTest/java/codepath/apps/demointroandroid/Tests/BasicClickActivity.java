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

import codepath.apps.demointroandroid.BasicClickHandlersActivity;
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
public class BasicClickActivity {


    @Rule
    public ActivityTestRule<BasicClickHandlersActivity> mActivityRule = new ActivityTestRule<>(
            BasicClickHandlersActivity.class);


    @Test
    public void checksDialogButtonJava() {

        onView(ViewMatchers.withId(R.id.btnClick2))
                .perform(click());

        onView(withText("CodePath Demo Intro Android")).inRoot(isDialog()).check(matches(isDisplayed()));

        //verifies if a certain activity is lauched. In this case, this activity already exists, but i'm using just to demonstrate
        //intended(hasComponent(BasicClickHandlersActivity.class.getName()));

        ViewInteraction buttonOK = onView(withText("OK"));
        buttonOK.perform(click());

       // onView(withId(R.id.a)).check(matches(withText("Hello world!")));

        onView(withId(R.id.textView1)).check(matches(withText("Hello world!")));
        onView(withId(R.id.textView1)).check(matches(isDisplayed()));

        onView(withText("BasicClickHandlersActivity")).check(matches(isDisplayed()));


        //TO DO: Verify if the menu bar has the correponding title to validate if after pressing OK, the app redirected to the other activity

    }

    @Test
    public void checksDialogButtonXML() {

        onView(withId(R.id.btnClick1))
                .perform(click());

        onView(withText("CodePath Demo Intro Android")).inRoot(isDialog()).check(matches(isDisplayed()));
        //onView(withId("message")).inRoot(isDialog()).check(matches(isDisplayed()));

        ViewInteraction buttonOK = onView(withText("OK"));
        buttonOK.perform(click());

        onView(withId(R.id.textView1)).check(matches(withText("Hello world!")));
        onView(withId(R.id.textView1)).check(matches(isDisplayed()));

    }

    @Test
    public void checksIfDialogsClosesWithBackButton() {

        onView(withId(R.id.btnClick2))
                .perform(click());

        onView(withText("CodePath Demo Intro Android")).inRoot(isDialog()).check(matches(isDisplayed()));

        Espresso.pressBack();

        // onView(withId(R.id.a)).check(matches(withText("Hello world!")));

        onView(withId(R.id.textView1)).check(matches(withText("Hello world!")));
        onView(withId(R.id.textView1)).check(matches(isDisplayed()));

    }
}
