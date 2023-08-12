package ru.sr.srmessenger.domain.repository

import android.content.Intent
import android.content.IntentSender
import ru.sr.srmessenger.domain.model.UserInfo

interface AuthRepository {
    suspend fun signIn(): Result<IntentSender>
    suspend fun signWithIntent(intent: Intent): Result<UserInfo>
    suspend fun signOut(): Boolean
    suspend fun getSignetUser(): Result<UserInfo>
}
