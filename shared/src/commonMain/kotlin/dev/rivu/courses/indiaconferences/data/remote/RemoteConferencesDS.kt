package dev.rivu.courses.indiaconferences.data.remote

import arrow.core.Either
import dev.rivu.courses.indiaconferences.data.ConferenceFilters
import dev.rivu.courses.indiaconferences.data.ConferencesDS
import dev.rivu.courses.indiaconferences.data.models.Conference

class RemoteConferencesDS : ConferencesDS {
    override suspend fun getAllConferences(conferenceFilters: ConferenceFilters): Either<Throwable, List<Conference>> {
        TODO("Not yet implemented")
    }

    override suspend fun addConference(conference: Conference): Either<Throwable, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteConference(conferenceId: String): Either<Throwable, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun updateConference(conferenceId: String, conference: Conference): Either<Throwable, Boolean> {
        TODO("Not yet implemented")
    }
}