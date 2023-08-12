package ru.sr.srmessenger.domain.useCase.api

import ru.sr.srmessenger.domain.model.UserInfo

interface CheckUserAuthUseCase {
    suspend operator fun invoke(): Result<UserInfo>
}