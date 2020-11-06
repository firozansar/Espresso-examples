package info.firozansari.espressoexamples

import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.LayoutAssertions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.MainActivity
import info.firozansari.espressoexamples.fragments.HierarchyFragment
import info.firozansari.espressoexamples.fragments.SwitchFragment
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Demonstrates usage of hierarchy-related tests, such as:
 * [ViewMatchers.withParent], [ViewMatchers.withParent], [ViewMatchers.hasDescendant]
 */
@RunWith(AndroidJUnit4::class)
class HierarchyActivityTests {

    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity{ activity ->
            UiThreadStatement.runOnUiThread {
                activity.displayFragment(HierarchyFragment())
            }
        }
    }
    /**
     * Test that there are no ellipsized texts in entire view hierarchy.
     */
    @Test
    fun testNoEllipsizedText() {
        Espresso.onView(ViewMatchers.withId(R.id.hierarchy_parent)).check(LayoutAssertions.noEllipsizedText())
    }

    /**
     * Test that there are no multiline buttons in entire view hierarchy.
     */
    @Test
    fun testNoMultilineButtons() {
        Espresso.onView(ViewMatchers.withId(R.id.hierarchy_parent)).check(LayoutAssertions.noMultilineButtons())
    }

    /**
     * Test the descendants of a selected view in entire view hierarchy.
     */
    @Test
    fun testNoOverlap() {
        Espresso.onView(ViewMatchers.withId(R.id.hierarchy_parent)).check(LayoutAssertions.noOverlaps())
    }

    /**
     * Test selecting a parent from two similar views.
     */
    @Test
    @Ignore
    fun testWithParent() {
        activityRule.scenario.onActivity { activity ->
            val contentDescription = activity.getString(R.string.hierarchy_text)
            Espresso.onView(Matchers.allOf(ViewMatchers.withContentDescription(contentDescription), ViewMatchers.withParent(ViewMatchers.withId(R.id.hierarchy_parent_two)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    /**
     * Test selecting a parent with child views that match
     */
    @Test
    fun testWithChild() {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.hierarchy_parent_two), ViewMatchers.withChild(ViewMatchers.withId(R.id.hierarchy_text_three)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test selecting a parent with a descendant that matches
     */
    @Test
    fun testHasDescendant() {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.hierarchy_parent_two), ViewMatchers.hasDescendant(ViewMatchers.withId(R.id.hierarchy_text_three)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test selecting a view that is the descendant of another view.
     */
    @Test
    fun testIsDescendantOfA() {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.hierarchy_text_three), ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.hierarchy_parent_two)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test selecting a view with a matching sibling.
     */
    @Test
    fun testHasSibling() {
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.hierarchy_text_three), ViewMatchers.hasSibling(ViewMatchers.withId(R.id.hierarchy_text_four)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}