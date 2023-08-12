package ru.sr.srmessenger

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class SrMessageColors(
    val background :Color,
)

val lightPalette = SrMessageColors(

    background = Color(0xFFCBDAE7),

)


val darkPalette = lightPalette.copy()

val LocalColorProvider =
    staticCompositionLocalOf<SrMessageColors> { error("No default implementation") }
