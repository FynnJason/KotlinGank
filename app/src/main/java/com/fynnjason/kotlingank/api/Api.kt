package com.fynnjason.kotlingank.api

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class Api {
    private val HOST = "http://gank.io/api/data/"

    fun Content(type: String, page: Int, num: Int): String = HOST + type + "/" + num + "/" + page

}