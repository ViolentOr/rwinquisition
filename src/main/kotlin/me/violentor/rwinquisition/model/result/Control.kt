package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

class Control {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    var id: String? = null
    @get:JsonProperty("title")
    @set:JsonProperty("title")
    var title: String? = null
    @get:JsonProperty("desc")
    @set:JsonProperty("desc")
    var desc: String? = null
    @get:JsonProperty("impact")
    @set:JsonProperty("impact")
    var impact: Float = 0.toFloat()
    @get:JsonProperty("refs")
    @set:JsonProperty("refs")
    var refs: Array<Any>? = null
    @get:JsonProperty("tags")
    @set:JsonProperty("tags")
    var tags: Tags? = null
    @get:JsonProperty("code")
    @set:JsonProperty("code")
    var code: String? = null
    @get:JsonProperty("source_location")
    @set:JsonProperty("source_location")
    var sourceLocation: SourceLocation? = null
    @get:JsonProperty("results")
    @set:JsonProperty("results")
    var results: List<ResultElement>? = null

    @JsonIgnore
    fun isSuccessfull() = this.results!![0].status == Status.PASSED
}
