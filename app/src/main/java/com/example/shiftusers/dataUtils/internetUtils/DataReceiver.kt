package com.example.shiftusers.dataUtils.internetUtils

import android.content.Context
import android.widget.Toast
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.request

object DataReceiver {
    private const val RANDOM_USERS_API_URI = "https://randomuser.me/api/"

    suspend fun getRawUserData(appContext: Context): String? {
        if (checkInternet(appContext)) {
            val client = HttpClient(CIO)
            val response = client.request<String>(RANDOM_USERS_API_URI)
            println(response)
            return response
        } else Toast.makeText(appContext, "Проблема с доступом в Интернет", Toast.LENGTH_SHORT)
            .show()
        return null
    }
}