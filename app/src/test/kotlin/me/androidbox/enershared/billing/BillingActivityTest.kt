package me.androidbox.enershared.billing

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.nhaarman.mockito_kotlin.*
import me.androidbox.enershared.R
import me.androidbox.enershared.core.FragmentManagerRetriever
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import org.robolectric.android.controller.ActivityController
import support.BaseRobolectricTestRunner

class BillingActivityTest: BaseRobolectricTestRunner() {
    private lateinit var billingActivityController: ActivityController<BillingActivity>

    @Before
    fun setup() {
        billingActivityController = Robolectric.buildActivity(BillingActivity::class.java)
    }

    @Test
    fun testBillingActivityIsNotNullValue() {
        assertThat(billingActivityController, `is`(notNullValue()))
    }

    @Test
    fun testBillingFragmentHasStarted() {
        billingActivityController.create()

        val actualFragment = billingActivityController.get()
                .supportFragmentManager
                .findFragmentByTag(BillingView.TAG)

        assertThat(actualFragment.tag, `is`(BillingView.TAG))
    }

    @Test
    fun testBillingFragment_commit_whenNotAttached() {
        val fragmentRetriever = mock<FragmentManagerRetriever>()
        val fragmentManager = mock<FragmentManager>()
        val fragmentTransaction = mock<FragmentTransaction>()
        val fragmentManagerOrder = inOrder(fragmentManager)
        val fragmentTransactionOrder = inOrder(fragmentTransaction)

        billingActivityController.get().fragmentRetriever = fragmentRetriever

        whenever(fragmentRetriever.getFragmentManager(billingActivityController.get()))
                .thenReturn(fragmentManager)
        whenever(fragmentManager.findFragmentByTag(BillingView.TAG))
                .thenReturn(null)
        whenever(fragmentManager.beginTransaction())
                .thenReturn(fragmentTransaction)

        billingActivityController.create()

        verify(fragmentRetriever).getFragmentManager(billingActivityController.get())
        verifyNoMoreInteractions(fragmentRetriever)

        fragmentManagerOrder.verify(fragmentManager).findFragmentByTag(BillingView.TAG)
        fragmentManagerOrder.verify(fragmentManager).beginTransaction()
        fragmentManagerOrder.verifyNoMoreInteractions()

        fragmentTransactionOrder.verify(fragmentTransaction).add(
                eq(R.id.billing_view_container), any<BillingView>(), eq(BillingView.TAG))
        fragmentTransactionOrder.verify(fragmentTransaction).commit()
        fragmentTransactionOrder.verifyNoMoreInteractions()
    }

    @Test
    fun testBillingFragment_doNotComment_whenAlreadyAttached() {
        val fragmentManagerRetriever = mock<FragmentManagerRetriever>()
        val fragmentManager = mock<FragmentManager>()
        billingActivityController.get().fragmentRetriever = fragmentManagerRetriever

        whenever(fragmentManagerRetriever.getFragmentManager(billingActivityController.get()))
                .thenReturn(fragmentManager)
        whenever(fragmentManager.findFragmentByTag(BillingView.TAG))
                .thenReturn(BillingView.newInstance())

        billingActivityController.create()

        verify(fragmentManagerRetriever).getFragmentManager(billingActivityController.get())
        verifyNoMoreInteractions(fragmentManagerRetriever)
        verify(fragmentManager).findFragmentByTag(BillingView.TAG)
        verifyNoMoreInteractions(fragmentManager)
    }
}
