package com.apppessoal.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.apppessoal.android.configurations.AppColors
import com.apppessoal.android.pages.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { AppPessoal() }
    }
}

@Composable
internal fun AppPessoal() {
    val colors = if (isSystemInDarkTheme()) {
        darkColorScheme(primary = Color(0xFF96D5B7))
    } else {
        lightColorScheme(
            primary = AppColors.Primary,
            onPrimary = AppColors.Surface,
            primaryContainer = AppColors.PrimaryContainer,
            onPrimaryContainer = AppColors.TextPrimary,
            background = AppColors.Background,
            onBackground = AppColors.TextPrimary,
            surface = AppColors.Surface,
            onSurface = AppColors.TextPrimary,
            onSurfaceVariant = AppColors.TextSecondary,
            outlineVariant = AppColors.Border,
        )
    }

    MaterialTheme(colorScheme = colors) {
        Home()
    }
}
