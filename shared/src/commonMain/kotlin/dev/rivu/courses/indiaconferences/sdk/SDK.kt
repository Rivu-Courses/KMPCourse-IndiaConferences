package dev.rivu.courses.indiaconferences.sdk

import dev.rivu.courses.indiaconferences.sdk.network.NetworkModule
import dev.rivu.courses.indiaconferences.sdk.network.UsersApi
import dev.rivu.courses.indiaconferences.sdk.network.models.UsersResponseItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

public class SDK: KoinComponent {
    private val usersAPi: UsersApi by inject()

    init {
        startKoin {
            modules(NetworkModule)
        }
    }

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