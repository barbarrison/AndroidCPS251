package com.example.sentientwatcher

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.sentientwatcher.ui.main.MainViewModel
import java.sql.Timestamp

class SentientObserver: LifecycleObserver {

    private val LogTag = "SentientObserver"
    var mainView = MainViewModel
    val timestamp = Timestamp(System.currentTimeMillis())

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mainView.addToOutputText("onResume triggered at $timestamp \n **********")
        Log.i(LogTag, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        mainView.addToOutputText("onPause triggered at $timestamp \n **********")
        Log.i(LogTag, "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mainView.addToOutputText("onCreate triggered at $timestamp")
        Log.i(LogTag, "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mainView.addToOutputText("onStart triggered at $timestamp")
        Log.i(LogTag, "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        mainView.addToOutputText("onStop triggered at $timestamp")
        Log.i(LogTag, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mainView.addToOutputText("onDestroy triggered at $timestamp \n **********")
        Log.i(LogTag, "onDestroy")
    }

}