package com.kierigby.bountyhunter;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ForgottenPassActivityTest {
    @Rule public final ActivityRule<ForgottenPassActivity> forgottenPassRule = new ActivityRule<>(ForgottenPassActivity.class);

    @Test
    public void checkCorrectText() {
        onView(withText("Forgotten Password")).check(matches(isDisplayed()));
        onView(withText("We can help you recover your password, but first we need a few details from you...")).check(matches(isDisplayed()));
        onView(withHint("Please enter your email")).check(matches(isDisplayed()));
    }

    @Test
    public void checkTextFields() {
        onView(withId(R.id.enterEmail)).perform(typeText("johnsmith123@gmail.com"));

    }

    @Test
    public  void checkButtons() {

    }

}
