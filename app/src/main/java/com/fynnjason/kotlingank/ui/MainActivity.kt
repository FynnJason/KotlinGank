package com.fynnjason.kotlingank.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.fynnjason.kotlingank.R
import com.fynnjason.kotlingank.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mTitles = listOf<String>("all", "Android", "iOS", "前端", "休息视频", "拓展资源")
    private var mFragments: ArrayList<Fragment> = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        for (i in 0..mTitles.size - 1) {
            mFragments.add(ContentFragment().getInstance(mTitles[i]))
        }
        tabMain.setupWithViewPager(vpMain)
    }

    private val tabMain by lazy {
        tab_main.tabMode = TabLayout.MODE_SCROLLABLE
        tab_main
    }

    private val vpMain by lazy {
        val adater = ViewPagerAdapter(supportFragmentManager, mFragments, mTitles)
        vp_main.adapter = adater
        vp_main
    }
}
