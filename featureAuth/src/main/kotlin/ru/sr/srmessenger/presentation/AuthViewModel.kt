package ru.sr.srmessenger.presentation

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.sr.srmessenger.domain.useCase.api.SignInUseCase
import ru.sr.srmessenger.domain.useCase.api.SignWithIntentUseCase
import ru.sr.srmessenger.presentation.model.AuthState

class AuthViewModel(
   private val signInUseCase: SignInUseCase,
   private val signWithIntentUseCase: SignWithIntentUseCase,
) : ViewModel() {

    private val _viewState: MutableStateFlow<AuthState> = MutableStateFlow(AuthState())
    val viewState = _viewState.asStateFlow()

   fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            signInUseCase.invoke()
                .onSuccess { intentSender ->
                    _viewState.update { state ->
                        state.copy(intentSender = intentSender)
                    }
                }
                .onFailure { exception: Throwable ->
                    exception.printStackTrace()
                }
        }
    }

    fun signWithIntentUseCase(intent: Intent) {
        viewModelScope.launch(Dispatchers.IO) {
            signWithIntentUseCase.invoke(intent)
                .onSuccess {
                    _viewState.update { state->
                        state.copy(isAuthUser = true)
                    }
                }
                .onFailure { exception: Throwable ->
                    exception.printStackTrace()
                }

        }
    }

}

