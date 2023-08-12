package ru.sr.srmessenger.domain.useCase.impl

import ru.sr.srmessenger.domain.repository.AuthRepository
import ru.sr.srmessenger.domain.model.UserInfo
import ru.sr.srmessenger.domain.useCase.api.CheckUserAuthUseCase

class CheckUserAuthUseCaseImpl(private val repository: AuthRepository): CheckUserAuthUseCase {
    override suspend fun invoke(): Result<UserInfo> {
        return repository.getSignetUser()
    }
}