package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class SourceLocation {
    @get:JsonProperty("line")
    @set:JsonProperty("line")
    var line: Long = 0
    @get:JsonProperty("ref")
    @set:JsonProperty("ref")
    var ref: String? = null
}
