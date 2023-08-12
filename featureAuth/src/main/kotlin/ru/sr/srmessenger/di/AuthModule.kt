package ru.sr.srmessenger.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.sr.srmessenger.data.repository.AuthRepositoryImpl
import ru.sr.srmessenger.domain.repository.AuthRepository
import ru.sr.srmessenger.domain.useCase.api.CheckUserAuthUseCase
import ru.sr.srmessenger.domain.useCase.api.SignInUseCase
import ru.sr.srmessenger.domain.useCase.api.SignOutUseCase
import ru.sr.srmessenger.domain.useCase.api.SignWithIntentUseCase
import ru.sr.srmessenger.domain.useCase.impl.CheckUserAuthUseCaseImpl
import ru.sr.srmessenger.domain.useCase.impl.SignInUseCaseImpl
import ru.sr.srmessenger.domain.useCase.impl.SignOutUseCaseImpl
import ru.sr.srmessenger.domain.useCase.impl.SignWithIntentUseCaseImpl
import ru.sr.srmessenger.presentation.AuthViewModel

fun authModule() = listOf(authRepositoryModule(), authUseCaseModule(), viewModule())

internal fun  authRepositoryModule() = module {
    factoryOf(::AuthRepositoryImpl){bind<AuthRepository>()}
}

internal fun  authUseCaseModule() = module {

    factoryOf(::CheckUserAuthUseCaseImpl){bind<CheckUserAuthUseCase>()}
    factoryOf(::SignInUseCaseImpl){bind<SignInUseCase>()}
    factoryOf(::SignOutUseCaseImpl){bind<SignOutUseCase>()}
    factoryOf(::SignWithIntentUseCaseImpl){bind<SignWithIntentUseCase>()}
}

internal fun  viewModule() = module {

    viewModelOf(::AuthViewModel)
}