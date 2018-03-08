// To use this code, add the following Maven dependency to your project:
//
//     com.fasterxml.jackson.core : jackson-databind : 2.9.0
//
// Import this package:
//
//     import me.violentor.rwinquisition.model.result.Converter;
//
// Then you can deserialize a JSON string with
//
//     Result data = Converter.fromJsonString(jsonString);

package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectReader
import com.fasterxml.jackson.databind.ObjectWriter
import java.io.IOException

interface Converter {
    var reader: ObjectReader?
    var writer: ObjectWriter?
    val objectReader: ObjectReader?
    val objectWriter: ObjectWriter?

    @Throws(IOException::class)
    fun fromJsonString(json: String): Result

    @Throws(JsonProcessingException::class)
    fun toJsonString(obj: Result): String

    fun instantiateMapper()
}