package me.androidbox.enershared.home;

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.widget.TextView
import me.androidbox.enershared.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UIHomeActivityTest {

    @Rule
    @JvmField
    val homeActivity: ActivityTestRule<HomeActivity>
            = ActivityTestRule(HomeActivity::class.java, true, false)

    @Before
    fun setup() {
        /* no-op */
    }

    @Test
    fun testHomeActivityIsDisplayedOnStarting() {
        homeActivity.launchActivity(Intent())

        onView(allOf(instanceOf(TextView::class.java), withParent(withId(R.id.tbHome))))
                .check(matches(withText(R.string.home)))
    }
}