package ru.sr.srmessenger.domain.useCase.api

interface SignOutUseCase {
    suspend operator fun invoke(): Boolean
}