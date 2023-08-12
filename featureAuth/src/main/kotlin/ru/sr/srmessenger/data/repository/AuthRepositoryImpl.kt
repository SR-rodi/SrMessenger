package ru.sr.srmessenger.data.repository

import android.content.Intent
import android.content.IntentSender
import android.util.Log
import ru.sr.srmessenger.domain.model.UserInfo
import ru.sr.srmessenger.domain.repository.AuthRepository
import ru.sr.srmessenger.remote.api.GoogleAuthApi

class AuthRepositoryImpl(
    private val authApi: GoogleAuthApi,
) : AuthRepository {
    override suspend fun signIn(): Result<IntentSender> {
        return try {
            Result.success(authApi.signIn())
        } catch (exception: Exception) {
            Log.e("kart","exception message = " +
                    "${exception}")
            Result.failure(exception)
        }
    }

    override suspend fun signWithIntent(intent: Intent): Result<UserInfo> {
        return try {
            val user = authApi.signWithIntent(intent)
            Result.success(
                UserInfo(
                    userId = user.userId,
                    userName = user.userName,
                    avatarUrl = user.avatarUrl
                )
            )

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    override suspend fun signOut(): Boolean {
        return try {
            authApi.signOut()
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }

    override suspend fun getSignetUser(): Result<UserInfo> {
        return try {
            val user = authApi.getSignetUser()
            Result.success(
                UserInfo(
                    userId = user.userId,
                    userName = user.userName,
                    avatarUrl = user.avatarUrl
                )
            )

        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}