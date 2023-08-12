package ru.sr.srmessenger

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class SrMessageFonts(
    val h1: TextStyle = baseFontStyle(textSize = 48.sp, weight = FontWeight.ExtraBold),
    val h2: TextStyle = baseFontStyle(textSize = 32.sp, weight = FontWeight.Normal),
    val h3: TextStyle = baseFontStyle(textSize = 24.sp, weight = FontWeight.SemiBold),
    val h4: TextStyle = baseFontStyle(textSize = 16.sp, weight = FontWeight.Normal),
    val p: TextStyle = baseFontStyle(textSize = 14.sp, weight = FontWeight.Light),
)

private fun baseFontStyle(textSize: TextUnit, weight: FontWeight) = TextStyle(
    fontSize = textSize,
    fontWeight = weight,
)

val fonts = SrMessageFonts()

val LocalFontProvider =
    staticCompositionLocalOf<SrMessageFonts> { error("No default implementation") }
