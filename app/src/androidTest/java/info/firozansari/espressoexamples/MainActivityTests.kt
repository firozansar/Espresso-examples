package info.firozansari.espressoexamples

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import info.firozansari.espressoexamples.activities.MainActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTests {
    /** Launches [MainActivity] for every test  */
    @Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    /**
     * Checks whether text on TextView gets changed after a button click
     */
    @Test
    fun testSwapText() {
        Espresso.onView(ViewMatchers.withId(R.id.change_text_button)).perform(ViewActions.click())
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.test_fragment_example_text), ViewMatchers.withText(R.string.example_text_after))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Checks whether a button is enabled.
     */
    @Test
    fun testIsEnabled() {
        Espresso.onView(ViewMatchers.withId(R.id.change_text_button)).check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }

    /**
     * Whether clicking on a CheckBox gets it checked
     */
    @Test
    fun testCheckingACheckBox() {
        Espresso.onView(ViewMatchers.withId(R.id.enabled_checkbox)).check(ViewAssertions.matches(ViewMatchers.isNotChecked())).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }

    /**
     * Test checking a checkbox
     * Test if you can press go, or next within an EditText
     */
    @Test
    fun testHasIME() {
        //hasImeAction(R.id.contentDescriptionText);
    }

    /**
     * Tests whether a CheckBox is disabled
     */
    @Test
    fun testIsCheckboxDisabled() {
        Espresso.onView(ViewMatchers.withId(R.id.disabled_checkbox)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())))
    }

    /**
     * Test a Button is clickable.
     */
    @Test
    fun testIsClickable() {
        Espresso.onView(ViewMatchers.withId(R.id.change_text_button)).check(ViewAssertions.matches(ViewMatchers.isClickable()))
    }

    /**
     * Click on a contextual menu item from the Overflow menu.
     */
    @Test
    fun testActionMenuItemClick() {
        Espresso.openContextualActionModeOverflowMenu()
        Espresso.onView(ViewMatchers.withText(R.string.action_settings)).perform(ViewActions.click())
    }

    /**
     * Whether EditText is focusable.
     */
    @Test
    fun testEditTextIsFocusable() {
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).check(ViewAssertions.matches(ViewMatchers.isFocusable()))
    }

    /**
     * Type text and confirm that text has been typed by searching for the text
     */
    @Test
    fun testTypeText() {
        val exampleText = "Here is a long piece of text to type out."
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.typeText(exampleText))
        // Example confirming this text has been successfully typed with just the text.
        Espresso.onView(ViewMatchers.withText(exampleText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Type text and confirm that text has been typed by searching for the text
     */
    @Test
    fun testTypeTextThenClear() {
        val exampleText = "Here is a long piece of text to type out."
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.typeText(exampleText))
        // Example confirming this text has been successfully typed with just the text.
        Espresso.onView(ViewMatchers.withText(exampleText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.clearText())
        // Check it is empty
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    /**
     * Type text and confirm that text has been typed by searching for the text
     */
    @Test
    fun testTypeTextThenReplace() {
        val exampleText = "Here is a long piece of text to type out."
        val exampleReplaceText = "Here is a long piece of text to replace."
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.typeText(exampleText))
        // Example confirming this text has been successfully typed with just the text.
        Espresso.onView(ViewMatchers.withText(exampleText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.replaceText(exampleReplaceText))
        // Check it is empty
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.test_fragment_edittext), ViewMatchers.withText(exampleReplaceText))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Type text and confirm that text has been typed by searching for the text and the ID of the textbox.
     */
    @Test
    fun testTypeTextWithTextAndId() {
        val exampleText = "Here is a long piece of text to type out."
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.typeText(exampleText))
        // Example confirming this text has been successfully typed with just the text.
        Espresso.onView(Matchers.allOf(ViewMatchers.withText(exampleText), ViewMatchers.withId(R.id.test_fragment_edittext))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Focus on an EditText and then close the Soft Keyboard that is displayed.
     */
    @Test
    fun testTypeTextCloseSoftKeyboard() {
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_edittext)).perform(ViewActions.click())
        Espresso.closeSoftKeyboard()
    }

    /**
     * Test the Content Description of a TextView
     */
    @Test
    fun testContentDescription() {
        val exampleContentDescription = activityRule.activity.getString(R.string.example_content_description)
        Espresso.onView(ViewMatchers.withId(R.id.test_fragment_content_description_text)).check(ViewAssertions.matches(ViewMatchers.hasContentDescription()))
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.test_fragment_content_description_text), ViewMatchers.withContentDescription(exampleContentDescription))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Usage example of startsWith()
     */
    @Test
    fun testStartsWith() {
        val textStartsWith = activityRule.activity.getString(R.string.example_content_description).substring(0, 5)
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.test_fragment_content_description_text), ViewMatchers.withText(CoreMatchers.startsWith(textStartsWith)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Usage example of endsWith()
     */
    @Test
    fun testEndsWith() {
        var textEndsWith = activityRule.activity.getString(R.string.example_content_description)
        textEndsWith = textEndsWith.substring(textEndsWith.length - 4)
        Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.test_fragment_content_description_text), ViewMatchers.withText(Matchers.endsWith(textEndsWith)))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Checks a View visible after scrolling to it using scrollTo()
     */
    @Test
    fun testScrollToButton() {
        Espresso.onView(ViewMatchers.withId(R.id.offscreen_button)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed()))).perform(ViewActions.scrollTo()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Example fo swipeUp()
     */
    @Test
    fun testScrollDown() {
        Espresso.onView(ViewMatchers.withId(R.id.scroll_view)).perform(ViewActions.swipeUp() /* Got to swipe up to scroll down. */)
    }

    /**
     * Example of swipeDown()
     */
    @Test
    fun testScrollUp() {
        Espresso.onView(ViewMatchers.withId(R.id.scroll_view)).perform(ViewActions.swipeDown() /* Got to swipe down to scroll up. */)
    }

    /**
     * Example of withHint()
     */
    @Test
    fun testSelectWithHint() {
        Espresso.onView(ViewMatchers.withHint(R.string.example_text_hint)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}