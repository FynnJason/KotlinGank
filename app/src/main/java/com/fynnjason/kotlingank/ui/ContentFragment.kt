package com.fynnjason.kotlingank.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fynnjason.kotlingank.R
import com.fynnjason.kotlingank.adapter.ContentAdapter
import com.fynnjason.kotlingank.api.Request
import com.fynnjason.kotlingank.beans.GankBean
import com.fynnjason.kotlingank.beans.GankListBean
import com.fynnjason.kotlingank.extensions.Loge
import com.fynnjason.kotlingank.extensions.inflate
import com.google.gson.Gson
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_content.*
import java.util.*

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class ContentFragment : Fragment() {
    private var mType: String = ""
    private var mPage = 1
    private var mDatas = ArrayList<GankBean>()
    private var mAdapter = ContentAdapter(R.layout.item_content, mDatas)

    fun getInstance(type: String): Fragment {
        mType = type
        return this
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Loge("onCreateView $mType")
        return container?.inflate(R.layout.fragment_content)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Loge("onViewCreated $mType")
        initView()
        initListener()
        if (mDatas.size == 0) {
            Request().getData(mType, mPage, contentCallBack)
        }
    }

    private fun initListener() {
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val i = Intent()
            i.setAction("android.intent.action.VIEW")
            val url = Uri.parse(mAdapter.data[position].url)
            i.setData(url)
            startActivity(i)
        }
    }

    private fun initView() {
        rv_content.setHasFixedSize(true)
        rv_content.layoutManager = LinearLayoutManager(context)
        rv_content.adapter = mAdapter
    }

    private val contentCallBack = object : StringCallback() {
        override fun onSuccess(response: Response<String>?) {
            val json = response?.body()
            Loge(json.toString())
            try {
                val bean = Gson().fromJson(json, GankListBean::class.java)
                mDatas.addAll(bean.results)
                mAdapter.notifyDataSetChanged()
            } catch (e: Exception) {
                Loge(e.toString())
            }
        }
    }

}