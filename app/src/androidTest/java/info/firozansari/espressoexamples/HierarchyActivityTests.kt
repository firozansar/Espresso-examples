package info.firozansari.espressoexamples

import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.LayoutAssertions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.HierarchyActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Demonstrates usage of hierarchy-related tests, such as:
 * [ViewMatchers.withParent], [ViewMatchers.withParent], [ViewMatchers.hasDescendant]
 */
@RunWith(AndroidJUnit4::class)
class HierarchyActivityTests {
    /** Launches [HierarchyActivity] for every test  */
    @Rule
    var activityRule = ActivityTestRule(HierarchyActivity::class.java)

    /**
     * Test the descendants of a selected view.
     */
    @Test
    fun testSelectedDescendants() {
        ViewAssertions.selectedDescendantsMatch(ViewMatchers.isAssignableFrom(TextView::class.java), ViewMatchers.withText(activityRule.activity.getString(R.string.hierarchy_text))).check(createATestView(), null)
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
    fun testWithParent() {
        val contentDescription = activityRule.activity.getString(R.string.hierarchy_text)
        Espresso.onView(Matchers.allOf(ViewMatchers.withContentDescription(contentDescription), ViewMatchers.withParent(ViewMatchers.withId(R.id.hierarchy_parent_two)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
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

    // https://code.google.com/p/android-test-kit/source/browse/espresso/libtests/src/main/java/com/google/android/apps/common/testing/ui/espresso/assertion/ViewAssertionsTest.java?r=9f9565f2c40130574b80bc67845120a72a66a517
    fun createATestView(): View {
        val parent: ViewGroup = RelativeLayout(activityRule.activity)
        val tv = TextView(activityRule.activity)
        tv.text = activityRule.activity.getString(R.string.hierarchy_text)
        parent.addView(tv)
        return parent
    }
}