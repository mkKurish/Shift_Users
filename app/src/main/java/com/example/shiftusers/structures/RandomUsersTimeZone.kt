package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class RandomUsersTimeZone(
    var offset: String? = null,
    var description: String? = null
): RealmObject()
