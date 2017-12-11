package com.fynnjason.kotlingank.application

import android.app.Application
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.interceptor.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * author：FynnJason
 * copyright：© 2017 Android.Own.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initOkgo()
    }

    private fun initOkgo() {
        //创建builder
        val builder = OkHttpClient.Builder()
        //配置log
        val log = HttpLoggingInterceptor("KotlinGank")
        log.setPrintLevel(HttpLoggingInterceptor.Level.BODY)
        log.setColorLevel(Level.INFO)
        builder.addInterceptor(log)
        //配置超时时间
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
        //初始化
        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build())
                .setCacheMode(CacheMode.NO_CACHE) //全局统一缓存模式，默认不使用缓存
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE) //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3) //全局统一超时重连次数，默认为三次
    }
}