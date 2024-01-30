package com.example.shiftusers.dataUtils.internetUtils

import android.content.Context
import com.example.shiftusers.structures.ShiftUser
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

object DataParser{
    fun saveUsersData(){
        TODO("Implementation with realm")
    }

    fun getOrGenerateUsers(appContext: Context): List<ShiftUser> {
        TODO("Try with getStoredUsers(), else generateUsers()")
    }

    fun generateUsers(appContext: Context, count: Int = 10): List<ShiftUser> {
        val generatedUsers = mutableListOf<ShiftUser>()
        repeat(count){
            getUser(appContext)?.let { it1 -> generatedUsers.add(it1) }
        }
        return generatedUsers
    }

    private fun getStoredUsers(): List<ShiftUser> {
        TODO("Implementation with realm")
    }

    private fun getUser(appContext: Context): ShiftUser? {
        var user: ShiftUser?
        runBlocking {
            user = async {
                val rawJSON = DataReceiver.getRawUserData(appContext)
                rawJSON?.let { Json.decodeFromString<ShiftUser>(it) }
            }.await()
        }
        return user
    }
}