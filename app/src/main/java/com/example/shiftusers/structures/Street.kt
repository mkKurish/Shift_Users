package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class Street(
    var number: Int? = null,
    var name: String? = null
): RealmObject()
