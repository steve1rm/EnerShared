package me.androidbox.enershared.core

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

interface FragmentManagerRetriever {
    fun getFragmentManager(activity: FragmentActivity): FragmentManager
}


