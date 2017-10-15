package info.firozansari.espressoexamples;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import info.firozansari.espressoexamples.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Examples how to test with device rotation
 */
@RunWith (AndroidJUnit4.class)
public class DeviceRotationTests {

	public static final String SAMPLE_TEXT = "SAMPLE_TEXT";

	/** Launches {@link MainActivity} for every test */
	@Rule
	public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

	/** Checks that what has been typed into EditText is retained after screen rotation */
	@Test
	public void whenDeviceRotates_sameTextInputIsRetained() {
		//GIVEN
		onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(typeText(SAMPLE_TEXT));
		//WHEN
		rotateDevice();
		//THEN
		onView(withId(R.id.test_fragment_edittext)).check(matches(withText(SAMPLE_TEXT)));
	}

	private void rotateDevice() {
		activityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

}
