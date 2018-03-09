package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.databind.ObjectWriter

import java.io.IOException

object ConverterImpl : Converter {

    override var reader: ObjectReader? = null
    override var writer: ObjectWriter? = null

    override val objectReader: ObjectReader?
        get() {
            if (reader == null) instantiateMapper()
            return reader
        }

    override val objectWriter: ObjectWriter?
        get() {
            if (writer == null) instantiateMapper()
            return writer
        }
    // Serialize/deserialize helpers

    @Throws(IOException::class)
    override fun fromJsonString(json: String): Result {
        return objectReader!!.readValue(json)
    }

    @Throws(JsonProcessingException::class)
    override fun toJsonString(obj: Result): String {
        return objectWriter!!.writeValueAsString(obj)
    }

    override fun instantiateMapper() {
        val mapper = ObjectMapper()
        reader = mapper.readerFor(Result::class.java)
        writer = mapper.writerFor(Result::class.java)
    }
}
