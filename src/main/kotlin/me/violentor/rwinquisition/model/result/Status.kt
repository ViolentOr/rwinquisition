package me.violentor.rwinquisition.model.result


import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

import java.io.IOException

enum class Status {
    FAILED, PASSED;

    @JsonValue
    fun toValue(): String? {
        when (this) {
            FAILED -> return "failed"
            PASSED -> return "passed"
        }
        return null
    }

    companion object {

        @JsonCreator
        @Throws(IOException::class)
        fun forValue(value: String): Status {
            if (value == "failed") return FAILED
            if (value == "passed") return PASSED
            throw IOException("Cannot deserialize Status")
        }
    }
}
