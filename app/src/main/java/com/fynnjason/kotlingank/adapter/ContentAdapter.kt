package com.fynnjason.kotlingank.adapter

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.fynnjason.kotlingank.R
import com.fynnjason.kotlingank.beans.GankBean
import com.fynnjason.kotlingank.config.Values
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class ContentAdapter(layoutResId: Int, data: MutableList<GankBean>?) : BaseQuickAdapter<GankBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: GankBean?) {
        helper?.setText(R.id.tv_des, item?.desc)
                ?.setText(R.id.tv_author, "[" + item?.who + "]")
                ?.setText(R.id.tv_type, item?.type)

        //判断icon类型
        val icon = helper?.getView<ImageView>(R.id.iv_type)
        when (item?.type) {
            Values.ALL -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_view_comfy))
            Values.ANDROID -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_android))
            Values.IOS -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_apple))
            Values.FRONT_END-> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_language_javascript))
            Values.REST_VIDEO -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_collection_video))
            Values.EXPAND_RESOURSE -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_view_module))
            Values.CASUAL_RECOMMEND ->icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_view_day))
        }
        //判断是否是福利图
        val iv = helper?.getView<ImageView>(R.id.iv_content)
        if (item?.type.equals("福利")) {
            iv?.visibility = View.VISIBLE
            Glide.with(mContext).load(item?.url).into(iv)
        } else {
            iv?.visibility = View.GONE
        }
    }
}