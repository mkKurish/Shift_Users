package com.example.shiftusers.structures

import com.example.shiftusers.structures.serializers.PostcodeSerializer
import io.realm.RealmObject
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
open class Location(
    var street: Street? = null,
    var city: String? = null,
    var state: String? = null,
    var country: String? = null,
    @Serializable(with = PostcodeSerializer::class)
    var postcode: String? = null,
    var coordinates: Coordinates? = null,
    var timezone: RandomUsersTimeZone? = null
): RealmObject()