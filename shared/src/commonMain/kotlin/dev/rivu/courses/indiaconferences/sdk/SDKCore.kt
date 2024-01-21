package dev.rivu.courses.indiaconferences.sdk

import dev.rivu.courses.indiaconferences.sdk.network.NetworkComponent
import dev.rivu.courses.indiaconferences.sdk.network.UsersApi
import dev.rivu.courses.indiaconferences.sdk.network.models.UsersResponseItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject
import me.tatarka.inject.annotations.Provides

@Inject
class SDKCore internal constructor(
    private val usersAPi: UsersApi
) {

    fun printUsers(): Job {
        return GlobalScope.launch {
            val users = usersAPi.getUsers()
            users.forEach { user ->
                println(user)
            }
        }
    }

    fun loadUsers(
        onSuccess: (List<UsersResponseItem>) -> Unit,
        onError: (Throwable) -> Unit
    ): Job {
        return GlobalScope.launch {
            val users = usersAPi.getUsers()
            users.forEach { user ->
                println(user)
            }
        }
    }

}

internal interface SDKComponent {
    val sdk: SDKCore
}