package com.example.shiftusers.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val spacingSmall: Dp = 4.dp
val spacingMedium: Dp = 10.dp
val spacingLarge: Dp = 20.dp

val cornersRadius: Dp = 15.dp
val cornersRound: Dp = 50.dp

data class CustomColors(
    val primaryText: Color,
    val secondaryText: Color,
    val background: Color,
    val mainCard: Color
)

fun customDarkColors() = CustomColors(
    primaryText = Color(0xFFFFFFFF),
    secondaryText = Color(0xFF999999),
    background = Color(0xFF0A0A0A),
    mainCard = Color(0xFF191919)
)

fun customLightColors() = CustomColors(
    primaryText = Color(0xFF000000),
    secondaryText = Color(0xFF888888),
    background = Color(0xFFECEDF0),
    mainCard = Color(0xFFFFFFFF)
)

object CustomTheme {
    val colors: CustomColors
        @Composable
        get() = localCustomColors.current
}

val localCustomColors = staticCompositionLocalOf<CustomColors> {
    error("No colors provided")
}

@Composable
fun MainTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val colors = if (isSystemInDarkTheme()) customDarkColors() else customLightColors()
    systemUiController.setSystemBarsColor(
        color = colors.background,
        darkIcons = !darkTheme
    )
    CompositionLocalProvider(
        localCustomColors provides colors,
        content = content
    )
}