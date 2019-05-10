package com.kierigby.bountyhunter;

import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



public class RegisterActivityTest {

    @Rule public ActivityTestRule<RegisterActivity> registerRule = new ActivityTestRule<>(RegisterActivity.class);
    @Test
    public void checkCorrectText() {
        onView(withText("Create An Account")).check(matches(isDisplayed()));
        onView(withText("Make an account so that you can start playing!")).check(matches(isDisplayed()));
        onView(withHint("First Name")).check(matches(isDisplayed()));
        onView(withHint("Last Name")).check(matches(isDisplayed()));
        onView(withHint("Pick a username")).check(matches(isDisplayed()));
        onView(withHint("Email Address")).check(matches(isDisplayed()));
        onView(withHint("Password")).check(matches(isDisplayed()));
        onView(withHint("Confirm your password")).check(matches(isDisplayed()));
    }


    @Test
    public void checkTextFields() {
        onView(withId(R.id.firstNameEditText)).perform(typeText("John"));
        onView(withId(R.id.lastNameEditText)).perform(typeText("Smith"));

        onView(withId(R.id.registerUsernameEditText)).perform(typeText("John123"));
        onView(withId(R.id.registerEmailEditText)).perform(typeText("johnsmith123@gmail.com"));

        onView(withId(R.id.registerPasswordEditText)).perform(typeText("Password1"));
        onView(withId(R.id.confirmPasswordEditText)).perform(typeText("Password1"));
    }

    @Test
    public void checkBackArrow() {

        //onView(withId(R.id.createAccountBtn)).check(matches(isClickable()));
        //onView(withId(R.id.backFromStats)).perform(click());
        //intended(hasClassName(com.kierigby.bountyhunter.MainActivity.class);
    }


}
