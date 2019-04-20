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
import static com.kierigby.bountyhunter.CustomMatchers.withDrawableId;


public class MainActivityTest {
    @Rule public final ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkCorrectTexts() {
        onView(withText("Forgot your Password?")).check(matches(isDisplayed()));
        onView(withHint("Username")).check(matches(isDisplayed()));
        onView(withHint("Password")).check(matches(isDisplayed()));

    }

    @Test
    public void checkTextFields() {
        onView(withId(R.id.loginUsernameEditText)).perform(typeText("UsernameTest1"));
        onView(withId(R.id.loginPasswordEditText)).perform(typeText("Password1"));
    }

    @Test
    public void checkCorrectDrawables() {
        onView(withId(R.id.logoImageView)).check(matches(withDrawableId(R.drawable.logo_with_marker)));
    }

}
