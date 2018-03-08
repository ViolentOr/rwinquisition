// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//     com.fasterxml.jackson.core : jackson-databind : 2.9.0
//
// Import this package:
//
//     import model.Converter;
//
// Then you can deserialize a JSON string with
//
//     Result data = Converter.fromJsonString(jsonString);

package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.databind.ObjectWriter

import java.io.IOException

object Converter {

    private var reader: ObjectReader? = null
    private var writer: ObjectWriter? = null

    private val objectReader: ObjectReader?
        get() {
            if (reader == null) instantiateMapper()
            return reader
        }

    private val objectWriter: ObjectWriter?
        get() {
            if (writer == null) instantiateMapper()
            return writer
        }
    // Serialize/deserialize helpers

    @Throws(IOException::class)
    fun fromJsonString(json: String): Result {
        return objectReader!!.readValue(json)
    }

    @Throws(JsonProcessingException::class)
    fun toJsonString(obj: Result): String {
        return objectWriter!!.writeValueAsString(obj)
    }

    private fun instantiateMapper() {
        val mapper = ObjectMapper()
        reader = mapper.reader(Result::class.java)
        writer = mapper.writerFor(Result::class.java)
    }
}
