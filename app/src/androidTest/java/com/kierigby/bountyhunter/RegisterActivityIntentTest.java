package com.kierigby.bountyhunter;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class RegisterActivityIntentTest {

    @Rule
    public IntentsTestRule<RegisterActivity> registerActivityIntentsTestRule = new IntentsTestRule<>(RegisterActivity.class);

    @Test
    public void checkCorrectRegistration() {
        onView(withId(R.id.firstNameEditText)).perform(typeText("John"));
        onView(withId(R.id.lastNameEditText)).perform(typeText("Smith"));

        onView(withId(R.id.registerUsernameEditText)).perform(typeText("John123"));
        onView(withId(R.id.registerEmailEditText)).perform(typeText("johnsmith123@gmail.com"));

        onView(withId(R.id.registerPasswordEditText)).perform(typeText("Password1"));
        onView(withId(R.id.confirmPasswordEditText)).perform(typeText("Password1"));
    }
}
