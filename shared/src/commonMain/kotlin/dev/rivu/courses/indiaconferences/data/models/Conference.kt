package dev.rivu.courses.indiaconferences.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Conference(
    @SerialName("link")
    val link: String = "",
    @SerialName("conference_end_date")
    val conferenceEndDate: String = "",
    @SerialName("conference_name")
    val conferenceName: String = "",
    @SerialName("conference_start_date")
    val conferenceStartDate: String = "",
    @SerialName("location")
    val location: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("is_paid")
    val isPaid: Boolean = false
)