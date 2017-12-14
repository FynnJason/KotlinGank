package com.fynnjason.kotlingank.extensions

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun Loge(msg: String) {
    Log.e("Gank",msg)
}
