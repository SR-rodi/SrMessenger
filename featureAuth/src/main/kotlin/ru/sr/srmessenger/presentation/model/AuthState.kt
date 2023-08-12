package ru.sr.srmessenger.presentation.model

import android.content.IntentSender

data class AuthState(
    val intentSender: IntentSender? = null,
    val isAuthUser: Boolean = false,
)