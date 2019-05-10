package com.kierigby.bountyhunter;

import org.junit.Rule;
import org.junit.Test;


import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class ForgottenPassActivityTest {
    @Rule public final ActivityTestRule<ForgottenPassActivity> forgottenPassRule = new ActivityTestRule<>(ForgottenPassActivity.class);

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
