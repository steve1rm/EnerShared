package me.androidbox.enershared.payment;

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import support.BaseRobolectricTestRunner


class PaymentActivityTest: BaseRobolectricTestRunner() {

    private lateinit var paymentActivity: PaymentActivity

    @Before
    fun setup() {
        paymentActivity = Robolectric
                .buildActivity(PaymentActivity::class.java)
                .create()
                .get()
    }

    @Test
    fun testPaymentActivityIsNotNullValue() {
        assertThat(paymentActivity, `is`(notNullValue()))
    }

    @Test
    fun testPaymentFragmentHasStarted() {
        val actualPaymentView = paymentActivity
                .supportFragmentManager
                .findFragmentByTag(PaymentView.TAG)

        assertThat(actualPaymentView.tag, `is`(PaymentView.TAG))
    }

    @Test
    fun testPaymentFragment_doNotCommit_WhenAlreadyAttached() {
        paymentActivity.recreate()

        val actualFragment = paymentActivity
                .supportFragmentManager
                .findFragmentByTag(PaymentView.TAG)

        assertThat(actualFragment.tag, `is`(PaymentView.TAG))
    }

}
