package info.firozansari.espressoexamples;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.ViewPagerActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith (AndroidJUnit4.class)
public class ViewPagerActivityTests {

	/** Launches {@link ViewPagerActivity} for every test */
	@Rule
	public ActivityTestRule<ViewPagerActivity> activityRule = new ActivityTestRule<>(ViewPagerActivity.class);

	/**
     * Swipe between the first and second pages in the ViewPager.
     */
    @Test
    public void testSwipeBetweenFirstAndSecondPage() {
        onView(withText("Test One")).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.pager)).perform(swipeLeft());
        onView(withText("Test Two")).check(matches(isDisplayed()));
    }

    /**
     * Swipe between the first and second pages and back to the first in the ViewPager.
     */
    @Test
    public void testSwipeBetweenFirstSecondAndBackToFirstPage() {
        onView(allOf(withId(R.id.example_text), withText("Test One"))).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withText("Test Two")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeRight());
        onView(withText("Test One")).check(matches(isDisplayed()));
    }

    /**
     * Swipe to the end of a Fragment
     */
    @Test
    public void testSwipeToTheEnd() {
        onView(withText("Test One")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft()).perform(swipeLeft()).perform(swipeLeft());
        onView(withText("Test Four")).check(matches(isDisplayed()));
    }

    /**
     * Swipe to the end of a Fragment and attempt to swipe further
     */
    @Test
    public void testSwipeBeyondTheEnd() {
        onView(withText("Test One")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft()).perform(swipeLeft()).perform(swipeLeft()).perform(swipeLeft());
        onView(withText("Test Four")).check(matches(isDisplayed()));
    }
}