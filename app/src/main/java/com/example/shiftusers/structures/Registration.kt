package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class Registration(
    var date: String? = null,
    var age: Int? = null
): RealmObject()
