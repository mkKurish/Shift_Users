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
@Serializer(forClass = BigInteger::class)
class BigIntegerSerializer {

    override fun deserialize(decoder: Decoder): BigInteger =
        when (decoder) {
            is JsonDecoder -> decoder.decodeJsonElement().jsonPrimitive.content.toBigInteger(radix = 16)
            else -> decoder.decodeString().toBigInteger(radix = 16)
        }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: BigInteger)  =
        when (encoder) {
            is JsonEncoder -> encoder.encodeJsonElement(JsonUnquotedLiteral(value.toString(16)))
            else -> encoder.encodeString(value.toString(16))
        }
}