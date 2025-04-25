package com.optcatalog.utils

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject


class FirebaseAnalyticsHelper @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics
) {
    fun logButtonClick(buttonName: String){
        val bundle = Bundle().apply {
            putString("button_name", buttonName)
        }
        firebaseAnalytics.logEvent("button_$buttonName", bundle)
    }

    fun logEvent(eventName:String){
        val bundle = Bundle().apply {
            putString("event_name", eventName)
        }

        firebaseAnalytics.logEvent("event_$eventName", bundle)
    }
}