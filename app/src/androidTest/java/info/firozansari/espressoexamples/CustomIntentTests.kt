package info.firozansari.espressoexamples

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.CustomIntentActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Examples how to test Activities that need to be launched with custom Intents
 */
@RunWith(AndroidJUnit4::class)
class CustomIntentTests {

    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(CustomIntentActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity { activity ->
            activity.startActivity(activity, MY_CUSTOM_TEXT)
        }
    }

    // onView() entry point to the view
    // ViewMatchers: A collection of objects that implement the Matcher<? super View> interface. You can pass one or more of these
    // to the onView() method to locate a view within the current view hierarchy.
    // ViewActions – A collection of ViewAction objects that can be passed to the ViewInteraction.perform() method, such as click().
    // ViewAssertions – A collection of ViewAssertion objects that can be passed the ViewInteraction.check() method.
    /* onView(withId(R.id.my_view))        // withId(R.id.my_view) is a ViewMatcher
			.perform(click())               // click() is a ViewAction
			.check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
	*/
    // If the target view is inside an AdapterView—such as ListView, GridView, or Spinner — the onView() method might not work. In these cases, you should use onData() instead.
    @Test
    fun textViewIsSetWithStringInCustomIntent() {
        onView(ViewMatchers.withId(R.id.custom_intent_textview)).check(ViewAssertions.matches(ViewMatchers.withText(MY_CUSTOM_TEXT)))
    }

    companion object {
        const val MY_CUSTOM_TEXT = "MY_CUSTOM_TEXT"
    }
}
