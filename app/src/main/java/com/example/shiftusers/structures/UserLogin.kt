package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class UserLogin(
    var uuid: String? = null,
    var username: String? = null,
    var password: String? = null,
    var salt: String? = null,
    var md5: String? = null,
    var sha1: String? = null,
    var sha256: String? = null
): RealmObject()