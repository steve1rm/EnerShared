package me.androidbox.enershared.billing

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.DrawerMatchers.isOpen
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.widget.TextView
import me.androidbox.enershared.R
import me.androidbox.enershared.home.HomeActivity
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UIBillingActivityTest {
    @Rule
    @JvmField
    val billingActivity = ActivityTestRule(HomeActivity::class.java, false, false)

    @Before
    fun setup() {
        /* no-op */
    }

    @Test
    fun testBillActivityIsDisplayed() {
        billingActivity.launchActivity(Intent())

        checkTheHomeScreenIsDisplayed()
        openNavigationDrawer()
        checkNavigationDrawerIsOpened()
        tapOnBillingItem()
        checkTheBillingScreenIsDisplayed()
    }

    private fun checkTheHomeScreenIsDisplayed() {
        onView(allOf(instanceOf(TextView::class.java), withParent(withId(R.id.tbHome))))
                .check(matches(withText(R.string.home)))
    }

    private fun openNavigationDrawer() {
        onView(withId(R.id.homeDrawerLayout)).perform(DrawerActions.open())
    }

    private fun checkNavigationDrawerIsOpened() {
        onView(withId(R.id.homeDrawerLayout)).check(matches(isOpen()))
    }

    private fun tapOnBillingItem() {
        onView(withId(R.id.nvHome)).perform(NavigationViewActions.navigateTo(R.id.menuBilling))
    }

    private fun checkTheBillingScreenIsDisplayed() {
        onView(allOf(instanceOf(TextView::class.java), withParent(withId(R.id.tbHome))))
                .check(matches(withText(R.string.billing)))
    }
}