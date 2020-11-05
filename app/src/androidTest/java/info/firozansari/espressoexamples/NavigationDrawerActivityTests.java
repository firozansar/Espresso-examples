package info.firozansari.espressoexamples;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.drawerlayout.widget.DrawerLayout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.NavigationDrawerActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.openDrawer;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/** Tests related to interacting with {@link DrawerLayout}  */
@RunWith (AndroidJUnit4.class)
public class NavigationDrawerActivityTests  {

	/** Launches {@link NavigationDrawerActivity} for every test */
	@Rule
	public ActivityTestRule<NavigationDrawerActivity> activityRule = new ActivityTestRule<>(NavigationDrawerActivity.class);

    /**
     * Test that clicking on a Navigation Drawer Item will open the correct fragment.
     * Espresso: openDrawer, onView, withText, perform, click, matches, check, isDisplayed
     */
    @Test
    public void testNavigationDrawerItemClick() {
        openDrawer(R.id.my_drawer_layout);
        onView(withText("Menu One")).perform(click());
        onView(allOf(withId(R.id.navigation_fragment_text), withText("Menu One"))).check(matches(isDisplayed()));
    }

    /**
     * Test opening the Navigation Drawer and pressing the back button.
     * Espresso: openDrawer, pressBack
     */
	@Test
    public void testNavigationDrawerBackButton() {
        openDrawer(R.id.my_drawer_layout);
        pressBack();
    }

}