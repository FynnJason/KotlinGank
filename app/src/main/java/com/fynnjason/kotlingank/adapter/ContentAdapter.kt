package com.fynnjason.kotlingank.adapter

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.fynnjason.kotlingank.R
import com.fynnjason.kotlingank.beans.GankBean
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
            "all" -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_view_comfy))
            "Android" -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_android))
            "iOS" -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_apple))
            "前端" -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_language_javascript))
            "休息视频" -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_collection_video))
            "拓展资源" -> icon?.setImageDrawable(IconicsDrawable(mContext)
                    .color(mContext.resources.getColor(R.color.colorAccent))
                    .icon(MaterialDesignIconic.Icon.gmi_view_module))
            "瞎推荐" ->icon?.setImageDrawable(IconicsDrawable(mContext)
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