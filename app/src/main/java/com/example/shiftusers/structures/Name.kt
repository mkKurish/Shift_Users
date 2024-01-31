package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class Name(
    var title: String? = null,
    var first: String? = null,
    var last: String? = null
): RealmObject()
