package me.androidbox.enershared.core

import android.view.View
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class BasePresenterImpTest {
    private lateinit var basePresenter: BasePresenter<View>

    @Before
    fun setup() {
        basePresenter = BasePresenterImp()
    }

    @Test
    fun testBasePresenterIsNotNullValue() {
        assertThat(basePresenter, `is`(notNullValue()))
    }

    @Test
    fun testAttachViewIsViewAttachedIsTrue() {
        val view: View = mock(View::class.java)

        basePresenter.attachView(view)

        assertThat(basePresenter.isViewAttached(), `is`(true))
    }
}