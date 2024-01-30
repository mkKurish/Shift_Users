package com.example.shiftusers.dataUtils.internetUtils

import android.content.Context
import com.example.shiftusers.structures.ShiftUser
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

object DataParser {
    fun saveUsersData() {
        TODO("Implementation with realm")
    }

    fun getOrGenerateUsers(appContext: Context): List<ShiftUser> {
        TODO("Try with getStoredUsers(), else generateUsers()")
    }

    fun generateUsers(appContext: Context, count: Int = 10): List<ShiftUser> {
        var user: RandomUsersResponseStructure?
        runBlocking {
            user = async {
                val rawJSON = DataReceiver.getRawUserData(appContext, count)
                rawJSON?.let { Json.decodeFromString<RandomUsersResponseStructure>(it) }
            }.await()
        }
        return user?.results ?: listOf()
    }

    private fun getStoredUsers(): List<ShiftUser> {
        TODO("Implementation with realm")
    }
}