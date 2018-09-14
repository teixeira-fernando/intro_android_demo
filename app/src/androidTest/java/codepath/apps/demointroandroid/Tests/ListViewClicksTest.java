package codepath.apps.demointroandroid.Tests;

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

import codepath.apps.demointroandroid.ListViewClicksActivity;
import codepath.apps.demointroandroid.R;
import codepath.apps.demointroandroid.Utils.ToastMatcher;

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

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListViewClicksTest {


    @Rule
    public ActivityTestRule<ListViewClicksActivity> mActivityRule = new ActivityTestRule<>(
            ListViewClicksActivity.class);

    @Test
    public void checksUSADialogContent() {

        String COUNTRY = "United States";

        onView(allOf(isDescendantOfA(ViewMatchers.withId(R.id.lvDemo)), withText(COUNTRY)))
                .perform(click());

        //verifies the content of the dialog
        onView(withText("CodePath Demo Intro Android")).inRoot(isDialog()).check(matches(isDisplayed()));
        onView(allOf(withId(android.R.id.message), withText(COUNTRY))).inRoot(isDialog()).check(matches(isDisplayed()));

        ViewInteraction buttonOK = onView(allOf(withId(android.R.id.button1), withText("OK")));
        buttonOK.perform(click());

        //recorded using espresso record tool
        ViewInteraction actionBarTitle = onView(allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("ListViewClicksActivity")));
        actionBarTitle.check(matches(isDisplayed()));
    }

    @Test
    public void checksCanadaDialogContent() {

        String COUNTRY = "Canada";

        onView(allOf(isDescendantOfA(ViewMatchers.withId(R.id.lvDemo)), withText(COUNTRY)))
                .perform(click());

        //verifies the content of the dialog
        onView(withText("CodePath Demo Intro Android")).inRoot(isDialog()).check(matches(isDisplayed()));
        onView(allOf(withId(android.R.id.message), withText(COUNTRY))).inRoot(isDialog()).check(matches(isDisplayed()));

        ViewInteraction buttonOK = onView(allOf(withId(android.R.id.button1), withText("OK")));
        buttonOK.perform(click());


        //recorded using espresso record tool
        ViewInteraction actionBarTitle = onView(allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("ListViewClicksActivity")));
        actionBarTitle.check(matches(isDisplayed()));
    }
}
