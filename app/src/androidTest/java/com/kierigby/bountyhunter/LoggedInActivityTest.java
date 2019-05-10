package com.kierigby.bountyhunter;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.kierigby.bountyhunter.CustomMatchers.withDrawableId;

@RunWith(AndroidJUnit4.class)
public class LoggedInActivityTest {
    @Rule
    public final ActivityRule<LoggedInActivity> loggedInRule = new ActivityRule<>(LoggedInActivity.class);

    @Test
    public void checkCorrectText() {
        onView(withText("Create Game")).check(matches(isDisplayed()));
        onView(withText("Game History")).check(matches(isDisplayed()));
        onView(withText("Game Rules")).check(matches(isDisplayed()));
        onView(withText("My Friends")).check(matches(isDisplayed()));

    }

    @Test
    public void checkClickableButtons() {
        onView(withId(R.id.tvCreateGame)).check(matches(isClickable()));
        onView(withId(R.id.tvGameHistory)).check(matches(isClickable()));
        onView(withId(R.id.tvGameRules)).check(matches(isClickable()));
        onView(withId(R.id.tvMyFriends)).check(matches(isClickable()));
    }
}
