package com.example.shiftusers.dataUtils.storageUtils

import com.example.shiftusers.structures.ShiftUser
import io.realm.Realm

fun addUserToDB(user: ShiftUser) {
    Realm.getDefaultInstance()
        .executeTransaction { realm ->
            realm.copyToRealm(user)
        }
}

fun getAllUsersFromDB(): List<ShiftUser>{
    val users = Realm.getDefaultInstance()
        .where(ShiftUser::class.java)
        .findAll()
    return users.toList()
}

fun clearDB(){
    Realm.getDefaultInstance()
        .executeTransaction{ transaction ->
            transaction.deleteAll()
        }
}