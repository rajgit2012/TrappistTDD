package com.trappist.logintdd.view;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.trappist.logintdd.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Raj Forhad on 06/01/2018.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkUserNameEditTextIsDisplayed() {
        loginActivityActivityTestRule.launchActivity(new Intent());
        onView(withId(R.id.editPassword)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPasswordEditTextIsDisplayed() {
        loginActivityActivityTestRule.launchActivity(new Intent());
        onView(withId(R.id.editPassword)).check(matches(isDisplayed()));
    }
    @Test
    public void checkErrorMessageIsDisplayedForEmptyData() {
        loginActivityActivityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginSuccess()
    {
        loginActivityActivityTestRule.launchActivity(new Intent());
        onView(withId(R.id.editUsername)).perform(typeText("rajforhadd"),closeSoftKeyboard());
        onView(withId(R.id.editPassword)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login successful.")).check(matches(isDisplayed()));
    }
}