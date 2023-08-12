package ru.sr.srmessenger.domain.useCase.impl

import android.content.Intent
import ru.sr.srmessenger.domain.repository.AuthRepository
import ru.sr.srmessenger.domain.model.UserInfo
import ru.sr.srmessenger.domain.useCase.api.SignWithIntentUseCase

class SignWithIntentUseCaseImpl(private val repository: AuthRepository): SignWithIntentUseCase {
    override suspend fun invoke(intent: Intent): Result<UserInfo> {
       return repository.signWithIntent(intent)
    }
}