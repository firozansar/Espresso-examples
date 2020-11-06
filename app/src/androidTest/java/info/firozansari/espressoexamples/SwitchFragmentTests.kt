package info.firozansari.espressoexamples

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.MainActivity
import info.firozansari.espressoexamples.fragments.SwitchFragment
import info.firozansari.espressoexamples.fragments.ViewPagerFragment
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/** Tests for [Switch] widget  */
@RunWith(AndroidJUnit4::class)
class SwitchFragmentTests {

    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity{ activity ->
            UiThreadStatement.runOnUiThread {
                activity.displayFragment(SwitchFragment())
            }
        }
    }

    /**
     * Click a switch using its ID.
     * Espresso onView, withId, check, matches, isChecked, perform
     */
    @Test
    fun testSwitchWithId() {
        onView(ViewMatchers.withId(R.id.example_switch)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isChecked())))
        onView(ViewMatchers.withId(R.id.example_switch)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.example_switch)).check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }

    /**
     * Click a switch using its label value.
     * Espresso onView, withText, check, matches, isChecked, perform, not
     */
    @Test
    fun testSwitchWithText() {
        onView(ViewMatchers.withText(R.string.example_switch_label)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isChecked())))
        onView(ViewMatchers.withText(R.string.example_switch_label)).perform(ViewActions.click())
        onView(ViewMatchers.withText(R.string.example_switch_label)).check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }

    /**
     * But why do that when you can chain it?
     * A three line test can now be written in a single line.
     * Espresso onView, withText, check, matches, not, isChecked, perform, click
     */
    @Test
    fun testSwitchWithChainingExample() {
        // Start with a ViewInteraction
        onView(ViewMatchers.withText(R.string.example_switch_label)) // Chain the methods you want to call.
                .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isChecked())))
                .perform(ViewActions.click())
                .check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }
}