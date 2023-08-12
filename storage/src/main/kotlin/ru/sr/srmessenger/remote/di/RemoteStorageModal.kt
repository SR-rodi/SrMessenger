package ru.sr.srmessenger.remote.di

import android.content.Context
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.sr.srmessanger.storage.R
import ru.sr.srmessenger.remote.api.GoogleAuthApi
import ru.sr.srmessenger.remote.data.AuthApiImpl

fun remoteStorageModal() = listOf(googleAuthApiModel())

internal fun googleAuthApiModel() = module {

    factoryOf(::SignInClientWrapper)

    factory {
        BeginSignInRequest.Builder().setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(get<Context>().resources.getString(R.string.web_client_id))
                .build()
        )
            .setAutoSelectEnabled(true)
            .build()
    }

    single { Firebase.auth }

    factoryOf(::AuthApiImpl){ bind<GoogleAuthApi>()}

}

    class SignInClientWrapper(context: Context){
        val client = Identity.getSignInClient(context)
    }