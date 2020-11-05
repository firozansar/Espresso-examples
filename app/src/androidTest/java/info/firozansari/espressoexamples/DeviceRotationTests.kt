package info.firozansari.espressoexamples

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Examples how to test with device rotation
 */
@RunWith(AndroidJUnit4::class)
class DeviceRotationTests {
    /** Launches [MainActivity] for every test  */
    @Rule
    @JvmField
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    /** Checks that what has been typed into EditText is retained after screen rotation  */
    @Test
    fun whenDeviceRotates_sameTextInputIsRetained() {
        //GIVEN
        onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.typeText(SAMPLE_TEXT))
        //WHEN
        rotateDevice()
        //THEN
        onView(ViewMatchers.withId(R.id.test_fragment_edittext)).check(ViewAssertions.matches(ViewMatchers.withText(SAMPLE_TEXT)))
    }

    private fun rotateDevice() {
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }

    companion object {
        const val SAMPLE_TEXT = "SAMPLE_TEXT"
    }
}