package ru.sr.srmessenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SrMessageTheme {

                rememberSystemUiController().setSystemBarsColor(color = SrMessageTheme.colors.background)
                NavHost(
                    modifier = Modifier
                        .background(SrMessageTheme.colors.background)
                        .fillMaxSize(),
                    navController = LocalNavController.current,
                    startDestination = AuthFlow.Auth.route,
                ) {
                    setNavGraph()
                }
            }
        }
    }
}
