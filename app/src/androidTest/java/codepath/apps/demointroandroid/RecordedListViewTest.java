package codepath.apps.demointroandroid;


import android.support.test.espresso.DataInteraction;
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

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecordedListViewTest {

    @Rule
    public ActivityTestRule<DemoSelector> mActivityTestRule = new ActivityTestRule<>(DemoSelector.class);

    @Test
    public void recordedListViewTest() {
        DataInteraction textView = onData(anything())
                .inAdapterView(allOf(withId(R.id.lvDemo),
                        childAtPosition(
                                withId(R.id.LinearLayout1),
                                0)))
                .atPosition(0);
        textView.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.message), withText("United States"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("United States")));

        ViewInteraction textView3 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("CodePath Demo Intro Android"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("CodePath Demo Intro Android")));

        ViewInteraction textView4 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("CodePath Demo Intro Android"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("CodePath Demo Intro Android")));

        ViewInteraction button = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        button.perform(click());

        ViewInteraction textView5 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("ListViewClicksActivity"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("ListViewClicksActivity")));

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
