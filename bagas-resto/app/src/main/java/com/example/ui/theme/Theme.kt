package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CustomDarkColorScheme = darkColorScheme(
    primary = AccentOrangeLight,
    onPrimary = Color(0xFF531800),
    primaryContainer = Color(0xFF7B2600),
    onPrimaryContainer = Color(0xFFFFDBCE),
    secondary = AccentAmberLight,
    onSecondary = Color(0xFF422E00),
    secondaryContainer = Color(0xFF5E4200),
    onSecondaryContainer = Color(0xFFFFE0A4),
    tertiary = AccentSageLight,
    onTertiary = Color(0xFF00391E),
    tertiaryContainer = Color(0xFF145233),
    onTertiaryContainer = Color(0xFF9DE0A9),
    background = DarkNavyBackground,
    onBackground = Color(0xFFE2E2E6),
    surface = DarkNavySurface,
    onSurface = Color(0xFFE2E2E6),
    surfaceVariant = Color(0xFF282F3D),
    onSurfaceVariant = Color(0xFFC3C6CF)
)

private val CustomLightColorScheme = lightColorScheme(
    primary = TerracottaPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDBD0),
    onPrimaryContainer = Color(0xFF3B0B00),
    secondary = HoneySecondary,
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFFFFDFA3),
    onSecondaryContainer = Color(0xFF2B1B00),
    tertiary = SageTertiary,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFD0F0D8),
    onTertiaryContainer = Color(0xFF00220F),
    background = CulinaryCreamBackground,
    onBackground = Color(0xFF1F1B16),
    surface = CulinaryCreamSurface,
    onSurface = Color(0xFF1F1B16),
    surfaceVariant = Color(0xFFF4E0CE),
    onSurfaceVariant = Color(0xFF51443A)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) CustomDarkColorScheme else CustomLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
