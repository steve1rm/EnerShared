package me.androidbox.enershared.billing

import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import support.BaseRobolectricTestRunner

class BillingActivityTest: BaseRobolectricTestRunner() {
    private lateinit var billingActivity: BillingActivity

    @Before
    fun setup() {
        billingActivity = Robolectric.setupActivity(BillingActivity::class.java)
    }

    @Test
    fun testBillingActivityIsNotNullValue() {
        assertThat(billingActivity, `is`(notNullValue()))
    }

    @Test
    fun testBillingFragmentHasStarted() {
        val actualFragment = billingActivity.supportFragmentManager.findFragmentByTag(BillingView.TAG)

        assertThat(actualFragment.tag, `is`(BillingView::class.java.name))
    }
}