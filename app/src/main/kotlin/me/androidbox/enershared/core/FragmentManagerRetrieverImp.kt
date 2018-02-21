package me.androidbox.enershared.core

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

class FragmentManagerRetrieverImp: FragmentManagerRetriever {
    override fun getFragmentManager(activity: FragmentActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}
