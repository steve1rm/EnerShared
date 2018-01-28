package me.androidbox.enershared.core

import android.view.View
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsNull.notNullValue
import org.hamcrest.core.IsNull.nullValue
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

    @Test
    fun testIsViewAttachedWhenViewIsNull() {
        assertThat(basePresenter.isViewAttached(), `is`(false))
    }

    @Test
    fun testIsViewAttachedWhenViewIsAttached() {
        val view = mock(View::class.java)

        basePresenter.attachView(view)
        basePresenter.detachView()

        assertThat(basePresenter.isViewAttached(), `is`(false))
    }

    @Test
    fun testGetViewReturnNullIfNoViewAttached() {
        assertThat(basePresenter.getView(), `is`(nullValue()))
    }

    @Test
    fun testGetViewReturnView() {
        val view = mock(View::class.java)

        basePresenter.attachView(view)

        assertThat(basePresenter.getView(), `is`(view))
    }

    @Test
    fun testDetachViewWhenNoViewAttached() {
        basePresenter.detachView()

        assertThat(basePresenter.isViewAttached(), `is`(false))
    }

    @Test
    fun testDetachViewWhenViewAttached() {
        val view = mock(View::class.java)
        basePresenter.attachView(view)

        basePresenter.detachView()

        assertThat(basePresenter.isViewAttached(), `is`(false))
    }
}