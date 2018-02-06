package info.firozansari.espressoexamples;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.CustomIntentActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Examples how to test Activities that need to be launched with custom Intents
 */
@RunWith(AndroidJUnit4.class)
public class CustomIntentTests {

	public static final String MY_CUSTOM_TEXT = "MY_CUSTOM_TEXT";

	@Rule
	public ActivityTestRule<CustomIntentActivity> rule = new ActivityTestRule<>(CustomIntentActivity.class,
			true, // initialTouchMode
			false); // launchActivity - false so we could customize the intent

	@Before
	public void setup() {
		Intent intent = new Intent();
		intent.putExtra(CustomIntentActivity.CUSTOM_TEXT, MY_CUSTOM_TEXT);
		rule.launchActivity(intent);
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
	public void textViewIsSetWithStringInCustomIntent() {

		onView(ViewMatchers.withId(R.id.custom_intent_textview)).check(matches(withText(MY_CUSTOM_TEXT)));
	}

}
