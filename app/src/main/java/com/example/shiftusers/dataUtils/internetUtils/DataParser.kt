package com.example.shiftusers.dataUtils.internetUtils

import android.content.Context
import com.example.shiftusers.dataUtils.storageUtils.addUserToDB
import com.example.shiftusers.dataUtils.storageUtils.getAllUsersFromDB
import com.example.shiftusers.structures.ShiftUser
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

object DataParser {
    fun saveUsersData(users: List<ShiftUser>) {
        users.forEach{
            addUserToDB(it)
        }
    }

    fun getOrGenerateUsers(appContext: Context): List<ShiftUser> {
        var users: List<ShiftUser> = getAllUsersFromDB()
        if (users.isEmpty()){
            users = generateUsers(appContext)
            saveUsersData(users)
        }
        return users
    }

    fun generateUsers(appContext: Context, count: Int = 15): List<ShiftUser> {
        var user: RandomUsersResponseStructure?
        runBlocking {
            user = async {
                val rawJSON = DataReceiver.getRawUserData(appContext, count)
                rawJSON?.let { Json.decodeFromString<RandomUsersResponseStructure>(it) }
            }.await()
        }
        return user?.results ?: listOf()
    }
}