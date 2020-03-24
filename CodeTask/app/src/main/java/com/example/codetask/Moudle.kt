package com.example.codetask

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val myModule = module {
    viewModel { InfoViewModel(get()) }
}

val repoModule = module {
    single { InfoRepository() }
}