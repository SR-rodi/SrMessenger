package ru.sr.srmessenger.domain.useCase.api

import android.content.Intent
import ru.sr.srmessenger.domain.model.UserInfo

interface SignWithIntentUseCase {
    suspend operator fun invoke(intent: Intent): Result<UserInfo>
}