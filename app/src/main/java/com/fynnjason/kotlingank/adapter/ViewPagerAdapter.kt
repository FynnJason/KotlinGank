package com.fynnjason.kotlingank.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class ViewPagerAdapter(fm: FragmentManager, fragments: List<Fragment>, titles: List<String>) : FragmentPagerAdapter(fm) {
    private var mFragments: List<Fragment>
    private var mTitles: List<String>

    init {
        mFragments = fragments
        mTitles = titles
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles.get(position % mTitles.size)
    }
}