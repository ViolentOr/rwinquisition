package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class Platform {
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    var name: String? = null
    @get:JsonProperty("release")
    @set:JsonProperty("release")
    var release: String? = null
}
