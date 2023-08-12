package ru.sr.srmessenger.domain.useCase.api

import android.content.IntentSender

interface SignInUseCase {
    suspend operator fun invoke(): Result<IntentSender>
}


