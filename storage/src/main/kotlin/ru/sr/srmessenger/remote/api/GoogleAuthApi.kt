package ru.sr.srmessenger.remote.api

import android.content.Intent
import android.content.IntentSender
import ru.sr.srmessenger.remote.data.UserInfoInApi

interface GoogleAuthApi {
    suspend fun signIn(): IntentSender
    suspend fun signWithIntent(intent: Intent): UserInfoInApi
    suspend fun signOut()
    suspend fun getSignetUser():UserInfoInApi
}