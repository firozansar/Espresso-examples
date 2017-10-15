package info.firozansari.espressoexamples;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.PositionActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isBottomAlignedWith;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftAlignedWith;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightAlignedWith;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.PositionAssertions.isTopAlignedWith;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/** Tests related to positioning of views such as isRightOf(), isBelow(), isTopAlignedWith().
 * */
@RunWith (AndroidJUnit4.class)
public class PositionActivityTests {

	/** Launches {@link PositionActivity} for every test */
	@Rule
	public ActivityTestRule<PositionActivity> activityRule = new ActivityTestRule<>(PositionActivity.class);

    /**
     * Is this to the left of another view.
     */
    @Test
    public void testRightOf() {
        onView(ViewMatchers.withId(R.id.right_text)).check(isRightOf(withId(R.id.left_text)));
    }

    /**
     * Is this to the left of another view.
     */
    @Test
    public void testLeftOf() {
        onView(withId(R.id.left_text)).check(isLeftOf(withId(R.id.right_text)));
    }

    /**
     * Is to the below another view.
     */
    @Test
    public void testBelow() {
        onView(withId(R.id.bottom_text)).check(isBelow(withId(R.id.right_text)));
    }

    /**
     * Is to the above another view.
     */
    @Test
    public void testAbove() {
        onView(withId(R.id.top_text)).check(isAbove(withId(R.id.right_text)));
    }

    /**
     * Is this to the top inside another view.
     */
    @Test
    public void testAlignedTopOfView() {
        onView(withId(R.id.top_text)).check(isTopAlignedWith(withId(R.id.parent_container)));
    }

    /**
     * Is this to the left inside another view.
     * This test will fail if the view being matches against has a passing or a margin.
     */
    @Test
    public void testAlignedLeftOfView() {
        onView(withId(R.id.top_text)).check(isLeftAlignedWith(withId(R.id.parent_container)));
    }

    /**
     * Is this to the right inside another view.
     * This test will fail if the view being matches against has a passing or a margin.
     */
    @Test
    public void testAlignedRightOfView() {
        onView(withId(R.id.bottom_text)).check(isRightAlignedWith(withId(R.id.parent_container)));
    }

    /**
     * Is this to the bottom inside another view.
     */
    @Test
    public void testAlignedBottomOfView() {
        onView(withId(R.id.bottom_text)).check(isBottomAlignedWith(withId(R.id.parent_container)));
    }

    /**
     * check if an element was not found in view hierarchy
     */
    public void testElementDoesNotExists() {
        onView(withId(R.id.navigation_fragment_text)).check(doesNotExist());
    }

}