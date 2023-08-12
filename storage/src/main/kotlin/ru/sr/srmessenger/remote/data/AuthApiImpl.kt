package ru.sr.srmessenger.remote.data

import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Status
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import ru.sr.srmessenger.remote.api.GoogleAuthApi
import ru.sr.srmessenger.remote.di.SignInClientWrapper

internal class AuthApiImpl(
    private val oneTapClient: SignInClientWrapper,
    private val beginSignInRequest: BeginSignInRequest,
    private val auth: FirebaseAuth,
) : GoogleAuthApi {

    override suspend fun signIn(): IntentSender {
        return try {
            oneTapClient.client.beginSignIn(beginSignInRequest)
                .await().pendingIntent.intentSender
        } catch (e: ApiException) {

            when (e.status) {

                Status.RESULT_CANCELED -> throw NonGoogleAccountException()
                Status.RESULT_DEAD_CLIENT -> throw NonGoogleAccountException()
                Status.RESULT_TIMEOUT -> throw TimeOutException()

                else -> throw UnSupportException()
            }
        }
    }

    override suspend fun signWithIntent(intent: Intent): UserInfoInApi {
        val credential = oneTapClient.client.getSignInCredentialFromIntent(intent)
        val googleToken = credential.googleIdToken
        val googleAuthCredential = GoogleAuthProvider.getCredential(googleToken, null)

        return try {
            val user = auth.signInWithCredential(googleAuthCredential)
                .await()
                .user
                ?: throw NonAuthException()

            UserInfoInApi(
                userId = user.uid,
                userName = user.displayName,
                avatarUrl = user.photoUrl.toString()
            )
        } catch (e: ApiException) {

            when (e.status) {
                Status.RESULT_CANCELED -> throw NonGoogleAccountException()
                Status.RESULT_DEAD_CLIENT -> throw NonGoogleAccountException()
                Status.RESULT_TIMEOUT -> throw TimeOutException()

                else -> throw UnSupportException()
            }
        }
    }

    override suspend fun signOut() {
        oneTapClient.client.signOut().await()
        auth.signOut()
    }

    override suspend fun getSignetUser(): UserInfoInApi {
        val user = auth.currentUser
            ?: throw NonAuthException()

        return UserInfoInApi(
            userId = user.uid,
            userName = user.displayName,
            avatarUrl = user.photoUrl.toString()
        )
    }
}

