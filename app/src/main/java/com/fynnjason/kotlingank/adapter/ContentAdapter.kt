package com.fynnjason.kotlingank.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.fynnjason.kotlingank.R
import com.fynnjason.kotlingank.beans.GankBean

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class ContentAdapter(layoutResId: Int, data: MutableList<GankBean>?) : BaseQuickAdapter<GankBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: GankBean?) {
        helper?.setText(R.id.tv_content, item?.desc + "[" + item?.who + "]")
    }
}