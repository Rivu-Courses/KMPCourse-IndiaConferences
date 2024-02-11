package dev.rivu.courses.indiaconferences.data

import arrow.core.Either
import dev.rivu.courses.indiaconferences.data.models.Conference
import io.ktor.util.reflect.Type

interface ConferencesDS {
    suspend fun getAllConferences(conferenceFilters: ConferenceFilters = ConferenceFilters()): Either<Throwable, List<Conference>>
    suspend fun addConference(conference: Conference): Either<Throwable, Boolean>
    suspend fun deleteConference(conferenceId: String): Either<Throwable, Boolean>
    suspend fun updateConference(conferenceId: String, conference: Conference): Either<Throwable, Boolean>
}

data class ConferenceFilters(
    val time: ConferenceTime? = null,
    val type: ConferenceType? = null,
) {
    enum class ConferenceType {
        Online, Offline
    }
    enum class ConferenceTime {
        Past, Future
    }
}