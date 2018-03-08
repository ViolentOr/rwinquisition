package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class Result {
    @get:JsonProperty("platform")
    @set:JsonProperty("platform")
    var platform: Platform? = null
    @get:JsonProperty("profiles")
    @set:JsonProperty("profiles")
    var profiles: Array<Profile>? = null
    @get:JsonProperty("statistics")
    @set:JsonProperty("statistics")
    var statistics: Statistics? = null
    @get:JsonProperty("version")
    @set:JsonProperty("version")
    var version: String? = null
}
