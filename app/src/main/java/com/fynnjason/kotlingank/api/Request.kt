package com.fynnjason.kotlingank.api

import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class Request {

    private val API = Api()

    private val NUM = 20;

    fun getData(type: String, page: Int, callback: StringCallback) {
        OkGo.get<String>(API.Content(type, page, NUM))
                .tag(type)
                .execute(callback)
    }
}