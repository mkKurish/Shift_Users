package com.example.shiftusers.structures.serializers

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonUnquotedLiteral
import kotlinx.serialization.json.jsonPrimitive
import java.math.BigInteger

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = String::class)
class PostcodeSerializer {

    override fun deserialize(decoder: Decoder): String =
        when (decoder) {
            is JsonDecoder -> decoder.decodeJsonElement().jsonPrimitive.content.toString()
            else -> decoder.decodeString().toString()
        }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: String)  =
        when (encoder) {
            is JsonEncoder -> encoder.encodeJsonElement(JsonUnquotedLiteral(value.toString()))
            else -> encoder.encodeString(value.toString())
        }
}