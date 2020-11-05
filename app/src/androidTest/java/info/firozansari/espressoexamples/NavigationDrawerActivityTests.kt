package info.firozansari.espressoexamples

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.NavigationDrawerActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/** Tests related to interacting with [DrawerLayout]   */
@RunWith(AndroidJUnit4::class)
class NavigationDrawerActivityTests {
    /** Launches [NavigationDrawerActivity] for every test  */
    @Rule
    var activityRule = ActivityTestRule(NavigationDrawerActivity::class.java)

    /**
     * Test that clicking on a Navigation Drawer Item will open the correct fragment.
     * Espresso: openDrawer, onView, withText, perform, click, matches, check, isDisplayed
     */
    @Test
    fun testNavigationDrawerItemClick() {
        DrawerActions.openDrawer(R.id.my_drawer_layout)
        Espresso.onView(ViewMatchers.withText("Menu One")).perform(ViewActions.click())
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.navigation_fragment_text), ViewMatchers.withText("Menu One"))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test opening the Navigation Drawer and pressing the back button.
     * Espresso: openDrawer, pressBack
     */
    @Test
    fun testNavigationDrawerBackButton() {
        DrawerActions.openDrawer(R.id.my_drawer_layout)
        Espresso.pressBack()
    }
}