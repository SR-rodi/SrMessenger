package ru.sr.srmessenger


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.sr.srmessenger.presentation.AuthScreen

fun NavGraphBuilder.setNavGraph() {

    composable(AuthFlow.Auth.route){
        AuthScreen()
    }

}