package com.kierigby.bountyhunter;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

public class MainActivityIntentTest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityIntentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void checkRegisterBtn() {
        onView(withId(R.id.registerBtn)).check(matches(isClickable()));
        onView(withId(R.id.registerBtn)).perform(click());
        intended(hasComponent(RegisterActivity.class.getName()));
    }

    @Test
    public void checkForgotPassBtn() {
        onView(withId(R.id.forgotPasswordtextView)).perform(click());
        intended(hasComponent(ForgottenPassActivity.class.getName()));
    }

    @Test
    public void checkLoginBtn() throws InterruptedException {
        onView(withId(R.id.loginUsernameEditText)).perform(replaceText("Azwad98"));
        onView(withId(R.id.loginPasswordEditText)).perform(replaceText("Password1!"));
        onView(withId(R.id.loginBtn)).perform(click());
        Thread.sleep(500);
        intended(hasComponent(LoggedInActivity.class.getName()));
    }

}
