package com.kierigby.bountyhunter;


import android.content.ComponentName;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;


@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {
    @Rule public final ActivityRule<RegisterActivity> registerRule = new ActivityRule<>(RegisterActivity.class);

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
