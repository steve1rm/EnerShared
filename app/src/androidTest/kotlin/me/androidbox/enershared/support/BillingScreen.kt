package me.androidbox.enershared.support

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.TextView
import me.androidbox.enershared.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

object BillingScreen {
    fun whileOnBillingScreen(): BillingScreen {
        onView(allOf(instanceOf(TextView::class.java), withParent(withId(R.id.tbHome))))
                .check(matches(withText(R.string.billing)))
        return this
    }
}