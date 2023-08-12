package ru.sr.srmessenger.presentation

import android.app.Activity.RESULT_OK
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthScreen(viewModel: AuthViewModel = koinViewModel()) {

    val viewState = viewModel.viewState.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(key1 = viewState.value.isAuthUser, ){
        if (viewState.value.isAuthUser){
            Toast.makeText(context, "Успешная авторизация", Toast.LENGTH_SHORT).show()
        }
    }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                scope.launch {
                    viewModel.signWithIntentUseCase(result.data ?: return@launch)
                }
            }
        }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Button(onClick = {
            viewModel.signIn()
            viewState.value.intentSender?.let { intentSender ->
                launcher.launch(
                    IntentSenderRequest.Builder(intentSender)
                        .build()
                )
            }
        }) {
            Text(text = "Google")
        }
    }

}