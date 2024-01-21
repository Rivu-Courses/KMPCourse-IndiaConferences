package dev.rivu.courses.indiaconferences.sdk.network

import org.koin.core.qualifier.named
import org.koin.dsl.module

val NetworkModule = module {
    single {
        UsersApi(get(), get(named("usersUrl")))
    }
    single {
        KtorClient
    }
    single(named("usersUrl")) {
        "https://jsonplaceholder.typicode.com/users"
    }
}