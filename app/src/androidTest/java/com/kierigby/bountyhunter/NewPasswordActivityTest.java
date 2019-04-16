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
import static com.kierigby.bountyhunter.CustomMatchers.withBackground;
import static com.kierigby.bountyhunter.CustomMatchers.withDrawableId;


@RunWith(AndroidJUnit4.class)
public class NewPasswordActivityTest {
    @Rule public final ActivityRule<NewPasswordActivity> newPassRule = new ActivityRule<> (NewPasswordActivity.class);

    @Test
    public void checkCorrectTexts() {
        onView(withText("New Password")).check(matches(isDisplayed()));
        onView(withHint("New Password")).check(matches(isDisplayed()));
        onView(withHint("Confirm New Password")).check(matches(isDisplayed()));
    }

    @Test
    public void checkTextFields() {
        onView(withId(R.id.etNewPassword)).perform(typeText("Password1"));
        onView(withId(R.id.etConfirmNewPassword)).perform(typeText("Password1"));
    }

    @Test
    public void checkCorrectDrawable() {
        onView(withId(R.id.image_top)).check(matches(withDrawableId(R.drawable.lock)));
        onView(withId(R.id.backFromSetNewPass)).check(matches(withBackground(R.drawable.keyboard_backspace)));
    }

}
