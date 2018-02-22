package me.androidbox.enershared.support

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.DrawerMatchers
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.TextView
import me.androidbox.enershared.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

object HomeScreen {

    fun whileOnHomePage(): HomeScreen {
        onView(allOf(instanceOf(TextView::class.java), withParent(withId(R.id.tbHome))))
                .check(matches(withText(R.string.home)))
        return this
    }

    fun openNavigationDrawer(): HomeScreen {
        onView(withId(R.id.homeDrawerLayout))
                .perform(DrawerActions.open())
        return this
    }

    fun closeNavigationDrawer(): HomeScreen {
        onView(withId(R.id.homeDrawerLayout))
                .perform(DrawerActions.close())
        return this
    }

    fun isNavigationDrawerOpen(): HomeScreen {
        onView(withId(R.id.homeDrawerLayout))
                .check(matches(DrawerMatchers.isOpen()))
        return this
    }

    fun isNavigationDrawerClosed(): HomeScreen {
        onView(withId(R.id.homeDrawerLayout))
                .check(matches(DrawerMatchers.isClosed()))
        return this
    }

    fun tapOnBillingMenu(): HomeScreen {
        onView(withId(R.id.nvHome)).perform(NavigationViewActions.navigateTo(R.id.menuBilling))
        return this
    }
}
