package com.fynnjason.kotlingank.beans

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
data class GankBean(val who: String, val desc: String, val type: String, val url: String)

data class GankListBean(val error: Boolean, val results: List<GankBean>)
