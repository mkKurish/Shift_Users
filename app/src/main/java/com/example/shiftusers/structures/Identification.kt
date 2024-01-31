package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class Identification(
    var name: String? = null,
    var value: String? = null
): RealmObject()
