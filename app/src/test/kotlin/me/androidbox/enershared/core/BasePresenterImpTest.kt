package me.androidbox.enershared.core

import android.view.View
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsNull.notNullValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

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
}