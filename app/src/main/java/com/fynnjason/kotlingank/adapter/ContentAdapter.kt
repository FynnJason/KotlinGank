package com.fynnjason.kotlingank.adapter

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
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
        helper?.setText(R.id.tv_des, item?.desc)
                ?.setText(R.id.tv_author, "[" + item?.who + "]")
                ?.setText(R.id.tv_type, item?.type)

        val iv = helper?.getView<ImageView>(R.id.iv_content)

        if (item?.type.equals("福利")) {
            iv?.visibility = View.VISIBLE
            Glide.with(mContext).load(item?.url).into(iv)
        } else {
            iv?.visibility = View.GONE
        }
    }
}