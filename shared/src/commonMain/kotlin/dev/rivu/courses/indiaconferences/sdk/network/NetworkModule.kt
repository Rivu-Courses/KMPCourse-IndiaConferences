package dev.rivu.courses.indiaconferences.sdk.network

import org.koin.dsl.module

val NetworkModule = module {
    single {
        UsersApi(get())
    }
    single {
        KtorClient
    }
}