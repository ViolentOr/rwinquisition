package me.violentor.rwinquisition.model.result

import com.fasterxml.jackson.annotation.JsonProperty

class Profile {
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    var name: String? = null
    @get:JsonProperty("version")
    @set:JsonProperty("version")
    var version: String? = null
    @get:JsonProperty("sha256")
    @set:JsonProperty("sha256")
    var sha256: String? = null
    @get:JsonProperty("title")
    @set:JsonProperty("title")
    var title: String? = null
    @get:JsonProperty("maintainer")
    @set:JsonProperty("maintainer")
    var maintainer: String? = null
    @get:JsonProperty("summary")
    @set:JsonProperty("summary")
    var summary: String? = null
    @get:JsonProperty("license")
    @set:JsonProperty("license")
    var license: String? = null
    @get:JsonProperty("copyright")
    @set:JsonProperty("copyright")
    var copyright: String? = null
    @get:JsonProperty("copyright_email")
    @set:JsonProperty("copyright_email")
    var copyrightEmail: String? = null
    @get:JsonProperty("supports")
    @set:JsonProperty("supports")
    var supports: Array<Any>? = null
    @get:JsonProperty("attributes")
    @set:JsonProperty("attributes")
    var attributes: Array<Any>? = null
    @get:JsonProperty("groups")
    @set:JsonProperty("groups")
    var groups: Array<Group>? = null
    @get:JsonProperty("controls")
    @set:JsonProperty("controls")
    var controls: Array<Control>? = null
}
