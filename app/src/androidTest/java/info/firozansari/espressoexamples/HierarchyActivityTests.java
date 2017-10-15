package info.firozansari.espressoexamples;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.HierarchyActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.LayoutAssertions.noEllipsizedText;
import static android.support.test.espresso.assertion.LayoutAssertions.noMultilineButtons;
import static android.support.test.espresso.assertion.LayoutAssertions.noOverlaps;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.assertion.ViewAssertions.selectedDescendantsMatch;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Demonstrates usage of hierarchy-related tests, such as:
 * {@link ViewMatchers#withParent}, {@link ViewMatchers#withParent}, {@link ViewMatchers#hasDescendant}
 */
@RunWith (AndroidJUnit4.class)
public class HierarchyActivityTests {

	/** Launches {@link HierarchyActivity} for every test */
	@Rule
	public ActivityTestRule<HierarchyActivity> activityRule = new ActivityTestRule<>(HierarchyActivity.class);
	
    /**
     * Test the descendants of a selected view.
     */
    @Test
    public void testSelectedDescendants() {
        selectedDescendantsMatch(isAssignableFrom(TextView.class), withText(activityRule.getActivity().getString(R.string.hierarchy_text))).check(createATestView(), null);
    }

    /**
     * Test that there are no ellipsized texts in entire view hierarchy.
     */
    @Test
    public void testNoEllipsizedText() {
       onView(withId(R.id.hierarchy_parent)).check(noEllipsizedText());
    }

    /**
     * Test that there are no multiline buttons in entire view hierarchy.
     */
    @Test
    public void testNoMultilineButtons() {
        onView(withId(R.id.hierarchy_parent)).check(noMultilineButtons());
    }

    /**
     * Test the descendants of a selected view in entire view hierarchy.
     */
    @Test
    public void testNoOverlap() {
        onView(withId(R.id.hierarchy_parent)).check(noOverlaps());
    }

    /**
     * Test selecting a parent from two similar views.
     */
    @Test
    public void testWithParent() {
        String contentDescription = activityRule.getActivity().getString(R.string.hierarchy_text);
        onView(allOf(withContentDescription(contentDescription), withParent(withId(R.id.hierarchy_parent_two)))).check(matches(isDisplayed()));
    }

    /**
     * Test selecting a parent with child views that match
     */
    @Test
    public void testWithChild() {
        onView(allOf(withId(R.id.hierarchy_parent_two), withChild(withId(R.id.hierarchy_text_three)))).check(matches(isDisplayed()));
    }

    /**
     * Test selecting a parent with a descendant that matches
     */
    @Test
    public void testHasDescendant() {
        onView(allOf(withId(R.id.hierarchy_parent_two), hasDescendant(withId(R.id.hierarchy_text_three)))).check(matches(isDisplayed()));
    }

    /**
     * Test selecting a view that is the descendant of another view.
     */
    @Test
    public void testIsDescendantOfA() {
        onView(allOf(withId(R.id.hierarchy_text_three), isDescendantOfA(withId(R.id.hierarchy_parent_two)))).check(matches(isDisplayed()));
    }

    /**
     * Test selecting a view with a matching sibling.
     */
    @Test
    public void testHasSibling() {
        onView(allOf(withId(R.id.hierarchy_text_three), hasSibling(withId(R.id.hierarchy_text_four)))).check(matches(isDisplayed()));
    }

    // https://code.google.com/p/android-test-kit/source/browse/espresso/libtests/src/main/java/com/google/android/apps/common/testing/ui/espresso/assertion/ViewAssertionsTest.java?r=9f9565f2c40130574b80bc67845120a72a66a517
    public View createATestView() {
        ViewGroup parent = new RelativeLayout(activityRule.getActivity());
        TextView tv = new TextView(activityRule.getActivity());
        tv.setText(activityRule.getActivity().getString(R.string.hierarchy_text));
        parent.addView(tv);
        return parent;
    }

}