package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class Coordinates(
    var latitude: Double? = null,
    var longitude: Double? = null
): RealmObject()
