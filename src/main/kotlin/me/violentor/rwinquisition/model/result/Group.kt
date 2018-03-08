package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class Group {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    var id: String? = null
    @get:JsonProperty("controls")
    @set:JsonProperty("controls")
    var controls: Array<String>? = null
}
