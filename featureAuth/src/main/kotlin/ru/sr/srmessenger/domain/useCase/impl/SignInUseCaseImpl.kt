package ru.sr.srmessenger.domain.useCase.impl

import android.content.IntentSender
import ru.sr.srmessenger.domain.repository.AuthRepository
import ru.sr.srmessenger.domain.useCase.api.SignInUseCase

class SignInUseCaseImpl(private val repository: AuthRepository) : SignInUseCase {
    override suspend fun invoke(): Result<IntentSender> {
        return repository.signIn()
    }
}