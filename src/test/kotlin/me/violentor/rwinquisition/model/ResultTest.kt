package me.violentor.rwinquisition.model

import me.violentor.rwinquisition.model.result.ConverterImpl
import me.violentor.rwinquisition.model.result.Result
import me.violentor.rwinquisition.model.result.Status
import org.junit.Test
import org.assertj.core.api.Assertions.*


class ResultJsonParserTest{

    private val resultJson = this::class.java.classLoader.getResource("mac.json").readText()

    @Test
    fun jsonCorrectlyMarshalsToObject() {
        val result: Result = ConverterImpl.fromJsonString(resultJson)

        assertThat(result).`as`("contains version attribute with correct value").hasFieldOrPropertyWithValue("version", "2.0.32")
                .hasFieldOrProperty("platform")
                .hasFieldOrProperty("profiles")
                .hasFieldOrProperty("statistics")

        assertThat(result.platform).hasFieldOrPropertyWithValue("name", "mac_os_x")
                .hasFieldOrPropertyWithValue("release", "17.4.0")

        assertThat(result.statistics).hasFieldOrPropertyWithValue("duration", 57.447338)

        assertThat(result.profiles).isNotNull()
    }

    @Test
    fun objectConvertsToJson(){
        val resultObject: Result = ConverterImpl.fromJsonString(resultJson)
        val resultString: String = ConverterImpl.toJsonString(resultObject)

        assertThat(resultString).contains("\"name\":\"cis-appleosx10.11-level2\"")
    }
}