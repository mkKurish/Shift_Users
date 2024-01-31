package com.example.shiftusers.structures

import io.realm.RealmObject
import kotlinx.serialization.Serializable

@Serializable
open class ShiftUser(
    var gender: String? = null,
    var name: Name? = null,
    var location: Location? = null,
    var email: String? = null,
    var login: UserLogin? = null,
    var dob: DoB? = null,
    var registered: Registration? = null,
    var phone: String? = null,
    var cell: String? = null,
    var id: Identification? = null,
    var picture: ProfilePic? = null,
    var nat: String? = null
): RealmObject()