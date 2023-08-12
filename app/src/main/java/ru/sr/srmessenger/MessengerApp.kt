package ru.sr.srmessenger

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.sr.srmessenger.di.authModule
import ru.sr.srmessenger.di.mainModule
import ru.sr.srmessenger.remote.di.remoteStorageModal

class MessengerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MessengerApp)
            modules(
                mainModule()
                        + remoteStorageModal()
                        + authModule()
            )
        }
    }
}