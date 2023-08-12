package ru.sr.srmessenger.domain.useCase.impl

import ru.sr.srmessenger.domain.repository.AuthRepository
import ru.sr.srmessenger.domain.useCase.api.SignOutUseCase

class SignOutUseCaseImpl(private val repository: AuthRepository): SignOutUseCase {
    override suspend fun invoke(): Boolean {
       return repository.signOut()
    }
}