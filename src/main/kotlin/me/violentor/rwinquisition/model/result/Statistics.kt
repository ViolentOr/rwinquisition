package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class Statistics {
    @get:JsonProperty("duration")
    @set:JsonProperty("duration")
    var duration: Double = 0.toDouble()
}
