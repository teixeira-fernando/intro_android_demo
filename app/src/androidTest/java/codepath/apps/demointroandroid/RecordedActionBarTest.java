package codepath.apps.demointroandroid;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecordedActionBarTest {

    @Rule
    public ActivityTestRule<DemoSelector> mActivityTestRule = new ActivityTestRule<>(DemoSelector.class);

    @Test
    public void recordedActionBarTest() {
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_toast), withContentDescription("Toast"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.android.internal.widget.ActionBarView")),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_toast), withContentDescription("Toast"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.android.internal.widget.ActionBarView")),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.menu_toast), withContentDescription("Toast"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.menu_launch), withContentDescription("Second"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.android.internal.widget.ActionBarView")),
                                        1),
                                1),
                        isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tvDisplayText), withText("No Passed Bundle :("),
                        childAtPosition(
                                allOf(withId(R.id.LinearLayout1),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("No Passed Bundle :(")));

        ViewInteraction textView3 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("SimpleBundleDemoActivity"),
                        childAtPosition(
                                childAtPosition(
                                        withContentDescription("SimpleBundleDemoActivity, Navigate home"),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("SimpleBundleDemoActivity")));

        pressBack();

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
