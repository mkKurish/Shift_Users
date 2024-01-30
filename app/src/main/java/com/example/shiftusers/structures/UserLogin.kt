package com.example.shiftusers.structures

import com.example.shiftusers.structures.serializers.BigIntegerSerializer
import com.example.shiftusers.structures.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.math.BigInteger
import java.util.UUID

@Serializable
data class UserLogin(
    @Serializable(with = UUIDSerializer::class)
    val uuid: UUID,
    val username: String,
    val password: String,
    val salt: String,
    @Serializable(with = BigIntegerSerializer::class)
    val md5: BigInteger,
    @Serializable(with = BigIntegerSerializer::class)
    val sha1: BigInteger,
    @Serializable(with = BigIntegerSerializer::class)
    val sha256: BigInteger
)