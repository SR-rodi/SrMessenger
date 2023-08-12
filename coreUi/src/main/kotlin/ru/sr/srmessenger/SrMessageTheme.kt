package ru.sr.srmessenger

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController

@Composable
fun SrMessageTheme(
    isNightMode: Boolean  = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {

    MaterialTheme{
        val color =  if (isNightMode) lightPalette else darkPalette

        CompositionLocalProvider(
            LocalNavController provides rememberNavController(),
            LocalShapeProvider provides shapes,
            LocalFontProvider provides fonts,
            LocalColorProvider provides color,
            content = content
        )
    }
}


object SrMessageTheme {
    val colors: SrMessageColors
        @Composable
        get() = LocalColorProvider.current
    val shapes: SrMessageShape
        @Composable
        get() = LocalShapeProvider.current
    val fonts: SrMessageFonts
        @Composable
        get() = LocalFontProvider.current
}