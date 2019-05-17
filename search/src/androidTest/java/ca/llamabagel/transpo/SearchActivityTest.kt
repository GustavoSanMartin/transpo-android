/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llamabagel.transpo

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import ca.llamabagel.transpo.ui.home.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class SearchActivityTest {

    @Rule
    @JvmField
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testNavigation() {
//        ActivityScenario.launch(MainActivity::class.java)

        rule.launchActivity(Intent(rule.activity, MainActivity::class.java))

        onView(withId(R.id.searchBtn)).perform(click())

        onView(withText("Search Activity!")).check(matches(isDisplayed()))
    }
}