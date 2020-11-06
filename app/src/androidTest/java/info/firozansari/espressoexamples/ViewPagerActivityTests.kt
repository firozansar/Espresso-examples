package info.firozansari.espressoexamples

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import info.firozansari.espressoexamples.activities.MainActivity
import info.firozansari.espressoexamples.activities.ViewPagerActivity
import info.firozansari.espressoexamples.fragments.ViewPagerFragment
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViewPagerActivityTests {

    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity{ activity ->
            runOnUiThread {
                activity.displayFragment(ViewPagerFragment())
            }
        }
    }

    /**
     * Swipe between the first and second pages in the ViewPager.
     */
    @Test
    fun testSwipeBetweenFirstAndSecondPage() {
        onView(ViewMatchers.withText("Test One")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft())
        onView(ViewMatchers.withText("Test Two")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Swipe between the first and second pages and back to the first in the ViewPager.
     */
    @Test
    fun testSwipeBetweenFirstSecondAndBackToFirstPage() {
        onView(Matchers.allOf(ViewMatchers.withId(R.id.example_text), ViewMatchers.withText("Test One"))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft())
        onView(ViewMatchers.withText("Test Two")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeRight())
        onView(ViewMatchers.withText("Test One")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Swipe to the end of a Fragment
     */
    @Test
    fun testSwipeToTheEnd() {
        onView(ViewMatchers.withText("Test One")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft()).perform(ViewActions.swipeLeft()).perform(ViewActions.swipeLeft())
        onView(ViewMatchers.withText("Test Four")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Swipe to the end of a Fragment and attempt to swipe further
     */
    @Test
    fun testSwipeBeyondTheEnd() {
        onView(ViewMatchers.withText("Test One")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.pager)).perform(ViewActions.swipeLeft()).perform(ViewActions.swipeLeft()).perform(ViewActions.swipeLeft()).perform(ViewActions.swipeLeft())
        onView(ViewMatchers.withText("Test Four")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}