package com.orels.deepsiam_client

import android.app.Application
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application() {

    companion object {
        private const val ONESIGNAL_APP_ID = "d370e9c5-215c-49a3-af70-30b4b044ced2" // Move to secured backend
    }

    override fun onCreate() {
        super.onCreate()
        registerToNotifications()
    }

    private fun registerToNotifications() {
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}