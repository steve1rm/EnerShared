package me.androidbox.enershared.core

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

interface FragmentRetriever {
    fun getFragment(fragmentManager: FragmentManager, tag: String): Fragment?
}
