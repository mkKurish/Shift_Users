package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class ProfilePic(
    var large: String? = null,
    var medium: String? = null,
    var thumbnail: String? = null
): RealmObject()
