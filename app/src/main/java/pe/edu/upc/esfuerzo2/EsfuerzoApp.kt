package pe.edu.upc.esfuerzo2

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.jacksonandroidnetworking.JacksonParserFactory
import pe.edu.upc.esfuerzo2.network.NewsApi

    class EsfuerzoApp:Application(){
        override fun onCreate() {
            super.onCreate()
            AndroidNetworking.initialize(applicationContext)
            AndroidNetworking.setParserFactory(JacksonParserFactory())
            NewsApi.apiKey = applicationContext.getString(R.string.new_api_key)
            NewsApi.refreshSourcesCaching()
        }

    }