package com.example.shiftusers.dataUtils.internetUtils

import android.content.Context
import android.widget.Toast
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.request

object DataReceiver {
    private const val RANDOM_USERS_API_URI = "https://randomuser.me/api/?results="

    suspend fun getRawUserData(appContext: Context, usersCount: Int): String? {
        if (usersCount < 1) {
            Toast.makeText(
                appContext,
                "Некорректное значение количества пользователей",
                Toast.LENGTH_SHORT
            )
                .show()
            return null
        }
        if (!checkInternet(appContext)) {
            Toast.makeText(appContext, "Проблема с доступом в Интернет", Toast.LENGTH_SHORT)
                .show()
            return null
        }
        return HttpClient(CIO).request<String>("$RANDOM_USERS_API_URI$usersCount")
            .replace("null", "\"\"")
    }
}