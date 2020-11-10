package info.firozansari.espressoexamples

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.PositionAssertions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import info.firozansari.espressoexamples.activities.MainActivity
import info.firozansari.espressoexamples.fragments.PositionFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/** Tests related to positioning of views such as isRightOf(), isBelow(), isTopAlignedWith().
 */
@RunWith(AndroidJUnit4::class)
class PositionFragmentTests {
    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity{ activity ->
            UiThreadStatement.runOnUiThread {
                activity.displayFragment(PositionFragment())
            }
        }
    }
    /**
     * Is this to the left of another view.
     */
    @Test
    fun testRightOf() {
        onView(ViewMatchers.withId(R.id.right_text)).check(PositionAssertions.isRightOf(ViewMatchers.withId(R.id.left_text)))
    }

    /**
     * Is this to the left of another view.
     */
    @Test
    fun testLeftOf() {
        onView(ViewMatchers.withId(R.id.left_text)).check(PositionAssertions.isLeftOf(ViewMatchers.withId(R.id.right_text)))
    }

    /**
     * Is to the below another view.
     */
    @Test
    fun testBelow() {
        onView(ViewMatchers.withId(R.id.bottom_text)).check(PositionAssertions.isBelow(ViewMatchers.withId(R.id.right_text)))
    }

    /**
     * Is to the above another view.
     */
    @Test
    fun testAbove() {
        onView(ViewMatchers.withId(R.id.top_text)).check(PositionAssertions.isAbove(ViewMatchers.withId(R.id.right_text)))
    }

    /**
     * Is this to the top inside another view.
     */
    @Test
    fun testAlignedTopOfView() {
        onView(ViewMatchers.withId(R.id.top_text)).check(PositionAssertions.isTopAlignedWith(ViewMatchers.withId(R.id.parent_container)))
    }

    /**
     * Is this to the left inside another view.
     * This test will fail if the view being matches against has a passing or a margin.
     */
    @Test
    fun testAlignedLeftOfView() {
        onView(ViewMatchers.withId(R.id.top_text)).check(PositionAssertions.isLeftAlignedWith(ViewMatchers.withId(R.id.parent_container)))
    }

    /**
     * Is this to the right inside another view.
     * This test will fail if the view being matches against has a passing or a margin.
     */
    @Test
    fun testAlignedRightOfView() {
        onView(ViewMatchers.withId(R.id.bottom_text)).check(PositionAssertions.isRightAlignedWith(ViewMatchers.withId(R.id.parent_container)))
    }

    /**
     * Is this to the bottom inside another view.
     */
    @Test
    fun testAlignedBottomOfView() {
        onView(ViewMatchers.withId(R.id.bottom_text)).check(PositionAssertions.isBottomAlignedWith(ViewMatchers.withId(R.id.parent_container)))
    }

    /**
     * check if an element was not found in view hierarchy
     */
    fun testElementDoesNotExists() {
        onView(ViewMatchers.withId(R.id.navigation_fragment_text)).check(ViewAssertions.doesNotExist())
    }
}