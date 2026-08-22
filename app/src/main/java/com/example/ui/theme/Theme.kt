package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = WhatsAppDarkTabSelected,
    onPrimary = WhatsAppDarkBg,
    primaryContainer = WhatsAppDarkSentBubble,
    onPrimaryContainer = WhatsAppDarkTextPrimary,
    secondary = WhatsAppDarkTabSelected,
    background = WhatsAppDarkBg,
    onBackground = WhatsAppDarkTextPrimary,
    surface = WhatsAppDarkSurface,
    onSurface = WhatsAppDarkTextPrimary,
    surfaceVariant = WhatsAppDarkReceivedBubble,
    onSurfaceVariant = WhatsAppDarkTextSecondary,
    outline = WhatsAppDarkBorder
)

private val LightColorScheme = lightColorScheme(
    primary = WhatsAppGreenPrimary,
    onPrimary = WhatsAppBackgroundLight,
    primaryContainer = WhatsAppSentBubbleLight,
    onPrimaryContainer = WhatsAppTextPrimaryLight,
    secondary = WhatsAppGreenLight,
    background = WhatsAppChatBackgroundLight,
    onBackground = WhatsAppTextPrimaryLight,
    surface = WhatsAppSurfaceLight,
    onSurface = WhatsAppTextPrimaryLight,
    surfaceVariant = WhatsAppReceivedBubbleLight,
    onSurfaceVariant = WhatsAppTextSecondaryLight,
    outline = WhatsAppTextSecondaryLight
)

@Composable
fun WhatsChatTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = if (darkTheme) WhatsAppDarkTopBar.toArgb() else WhatsAppGreenPrimary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
