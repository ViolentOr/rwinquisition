package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class ResultElement {
    @get:JsonProperty("status")
    @set:JsonProperty("status")
    var status: Status? = null
    @get:JsonProperty("code_desc")
    @set:JsonProperty("code_desc")
    var codeDesc: String? = null
    @get:JsonProperty("run_time")
    @set:JsonProperty("run_time")
    var runTime: Double = 0.toDouble()
    @get:JsonProperty("start_time")
    @set:JsonProperty("start_time")
    var startTime: String? = null
    @get:JsonProperty("message")
    @set:JsonProperty("message")
    var message: String? = null
}
