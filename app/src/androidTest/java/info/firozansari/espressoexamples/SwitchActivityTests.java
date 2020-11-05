package info.firozansari.espressoexamples;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.widget.Switch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.SwitchActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/** Tests for {@link Switch} widget */
@RunWith (AndroidJUnit4.class)
public class SwitchActivityTests {

	/** Launches {@link SwitchActivity} for every test */
	@Rule
	public ActivityTestRule<SwitchActivity> activityRule = new ActivityTestRule<>(SwitchActivity.class);

    /**
     * Click a switch using its ID.
     * Espresso onView, withId, check, matches, isChecked, perform
     */
    @Test
    public void testSwitchWithId() {
        onView(ViewMatchers.withId(R.id.example_switch)).check(matches(not(isChecked())));
        onView(withId(R.id.example_switch)).perform(click());
        onView(withId(R.id.example_switch)).check(matches(isChecked()));

    }

    /**
     * Click a switch using its label value.
     * Espresso onView, withText, check, matches, isChecked, perform, not
     */
    @Test
    public void testSwitchWithText() {
        onView(withText(R.string.example_switch_label)).check(matches(not(isChecked())));
        onView(withText(R.string.example_switch_label)).perform(click());
        onView(withText(R.string.example_switch_label)).check(matches(isChecked()));
    }

    /**
     * But why do that when you can chain it?
     * A three line test can now be written in a single line.
     * Espresso onView, withText, check, matches, not, isChecked, perform, click
     */
    @Test
    public void testSwitchWithChainingExample() {
        // Start with a ViewInteraction
        onView(withText(R.string.example_switch_label))
        // Chain the methods you want to call.
                .check(matches(not(isChecked())))
                .perform(click())
                .check(matches(isChecked()));
    }

}