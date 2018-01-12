package com.ahmadrosid.belajartdd;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ocittwo on 2/27/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkViewDisplayed(){
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.judul)).check(matches(isDisplayed()));
        onView(withId(R.id.kategori)).check(matches(isDisplayed()));
        onView(withId(R.id.konten)).check(matches(isDisplayed()));
    }

    @Test
    public void checkErrorMessageIsDisplayedForEmptyData() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btn_simpan)).check(matches(isDisplayed())).perform(click());
        onView(withText("Field Judul is empty!")).check(matches(isDisplayed()));
    }

    @Test
    public void checkSuccesSimpanArtikel() {
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.judul)).perform(typeText("judul test"), closeSoftKeyboard());
        onView(withId(R.id.kategori)).perform(typeText("kategori test"), closeSoftKeyboard());
        onView(withId(R.id.konten)).perform(typeText("konten test"), closeSoftKeyboard());
        onView(withId(R.id.btn_simpan)).check(matches(isDisplayed())).perform(click());
        onView(withText("Artikel dengan judul judul test telah berhasil disimpan")).check(matches(isDisplayed()));
    }
}