package me.androidbox.enershared.core

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class FragmentRetrieverImp: FragmentRetriever {
    override fun getFragment(fragmentManager: FragmentManager, tag: String): Fragment? {
        return fragmentManager.findFragmentByTag(tag)
    }
}