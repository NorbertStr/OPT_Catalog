import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.optcatalog.ui.theme.Typography
import com.optcatalog.ui.theme.backgroundDark
import com.optcatalog.ui.theme.backgroundDarkHighContrast
import com.optcatalog.ui.theme.backgroundDarkMediumContrast
import com.optcatalog.ui.theme.backgroundLight
import com.optcatalog.ui.theme.backgroundLightHighContrast
import com.optcatalog.ui.theme.backgroundLightMediumContrast
import com.optcatalog.ui.theme.errorContainerDark
import com.optcatalog.ui.theme.errorContainerDarkHighContrast
import com.optcatalog.ui.theme.errorContainerDarkMediumContrast
import com.optcatalog.ui.theme.errorContainerLight
import com.optcatalog.ui.theme.errorContainerLightHighContrast
import com.optcatalog.ui.theme.errorContainerLightMediumContrast
import com.optcatalog.ui.theme.errorDark
import com.optcatalog.ui.theme.errorDarkHighContrast
import com.optcatalog.ui.theme.errorDarkMediumContrast
import com.optcatalog.ui.theme.errorLight
import com.optcatalog.ui.theme.errorLightHighContrast
import com.optcatalog.ui.theme.errorLightMediumContrast
import com.optcatalog.ui.theme.inverseOnSurfaceDark
import com.optcatalog.ui.theme.inverseOnSurfaceDarkHighContrast
import com.optcatalog.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.optcatalog.ui.theme.inverseOnSurfaceLight
import com.optcatalog.ui.theme.inverseOnSurfaceLightHighContrast
import com.optcatalog.ui.theme.inverseOnSurfaceLightMediumContrast
import com.optcatalog.ui.theme.inversePrimaryDark
import com.optcatalog.ui.theme.inversePrimaryDarkHighContrast
import com.optcatalog.ui.theme.inversePrimaryDarkMediumContrast
import com.optcatalog.ui.theme.inversePrimaryLight
import com.optcatalog.ui.theme.inversePrimaryLightHighContrast
import com.optcatalog.ui.theme.inversePrimaryLightMediumContrast
import com.optcatalog.ui.theme.inverseSurfaceDark
import com.optcatalog.ui.theme.inverseSurfaceDarkHighContrast
import com.optcatalog.ui.theme.inverseSurfaceDarkMediumContrast
import com.optcatalog.ui.theme.inverseSurfaceLight
import com.optcatalog.ui.theme.inverseSurfaceLightHighContrast
import com.optcatalog.ui.theme.inverseSurfaceLightMediumContrast
import com.optcatalog.ui.theme.onBackgroundDark
import com.optcatalog.ui.theme.onBackgroundDarkHighContrast
import com.optcatalog.ui.theme.onBackgroundDarkMediumContrast
import com.optcatalog.ui.theme.onBackgroundLight
import com.optcatalog.ui.theme.onBackgroundLightHighContrast
import com.optcatalog.ui.theme.onBackgroundLightMediumContrast
import com.optcatalog.ui.theme.onErrorContainerDark
import com.optcatalog.ui.theme.onErrorContainerDarkHighContrast
import com.optcatalog.ui.theme.onErrorContainerDarkMediumContrast
import com.optcatalog.ui.theme.onErrorContainerLight
import com.optcatalog.ui.theme.onErrorContainerLightHighContrast
import com.optcatalog.ui.theme.onErrorContainerLightMediumContrast
import com.optcatalog.ui.theme.onErrorDark
import com.optcatalog.ui.theme.onErrorDarkHighContrast
import com.optcatalog.ui.theme.onErrorDarkMediumContrast
import com.optcatalog.ui.theme.onErrorLight
import com.optcatalog.ui.theme.onErrorLightHighContrast
import com.optcatalog.ui.theme.onErrorLightMediumContrast
import com.optcatalog.ui.theme.onPrimaryContainerDark
import com.optcatalog.ui.theme.onPrimaryContainerDarkHighContrast
import com.optcatalog.ui.theme.onPrimaryContainerDarkMediumContrast
import com.optcatalog.ui.theme.onPrimaryContainerLight
import com.optcatalog.ui.theme.onPrimaryContainerLightHighContrast
import com.optcatalog.ui.theme.onPrimaryContainerLightMediumContrast
import com.optcatalog.ui.theme.onPrimaryDark
import com.optcatalog.ui.theme.onPrimaryDarkHighContrast
import com.optcatalog.ui.theme.onPrimaryDarkMediumContrast
import com.optcatalog.ui.theme.onPrimaryLight
import com.optcatalog.ui.theme.onPrimaryLightHighContrast
import com.optcatalog.ui.theme.onPrimaryLightMediumContrast
import com.optcatalog.ui.theme.onSecondaryContainerDark
import com.optcatalog.ui.theme.onSecondaryContainerDarkHighContrast
import com.optcatalog.ui.theme.onSecondaryContainerDarkMediumContrast
import com.optcatalog.ui.theme.onSecondaryContainerLight
import com.optcatalog.ui.theme.onSecondaryContainerLightHighContrast
import com.optcatalog.ui.theme.onSecondaryContainerLightMediumContrast
import com.optcatalog.ui.theme.onSecondaryDark
import com.optcatalog.ui.theme.onSecondaryDarkHighContrast
import com.optcatalog.ui.theme.onSecondaryDarkMediumContrast
import com.optcatalog.ui.theme.onSecondaryLight
import com.optcatalog.ui.theme.onSecondaryLightHighContrast
import com.optcatalog.ui.theme.onSecondaryLightMediumContrast
import com.optcatalog.ui.theme.onSurfaceDark
import com.optcatalog.ui.theme.onSurfaceDarkHighContrast
import com.optcatalog.ui.theme.onSurfaceDarkMediumContrast
import com.optcatalog.ui.theme.onSurfaceLight
import com.optcatalog.ui.theme.onSurfaceLightHighContrast
import com.optcatalog.ui.theme.onSurfaceLightMediumContrast
import com.optcatalog.ui.theme.onSurfaceVariantDark
import com.optcatalog.ui.theme.onSurfaceVariantDarkHighContrast
import com.optcatalog.ui.theme.onSurfaceVariantDarkMediumContrast
import com.optcatalog.ui.theme.onSurfaceVariantLight
import com.optcatalog.ui.theme.onSurfaceVariantLightHighContrast
import com.optcatalog.ui.theme.onSurfaceVariantLightMediumContrast
import com.optcatalog.ui.theme.onTertiaryContainerDark
import com.optcatalog.ui.theme.onTertiaryContainerDarkHighContrast
import com.optcatalog.ui.theme.onTertiaryContainerDarkMediumContrast
import com.optcatalog.ui.theme.onTertiaryContainerLight
import com.optcatalog.ui.theme.onTertiaryContainerLightHighContrast
import com.optcatalog.ui.theme.onTertiaryContainerLightMediumContrast
import com.optcatalog.ui.theme.onTertiaryDark
import com.optcatalog.ui.theme.onTertiaryDarkHighContrast
import com.optcatalog.ui.theme.onTertiaryDarkMediumContrast
import com.optcatalog.ui.theme.onTertiaryLight
import com.optcatalog.ui.theme.onTertiaryLightHighContrast
import com.optcatalog.ui.theme.onTertiaryLightMediumContrast
import com.optcatalog.ui.theme.outlineDark
import com.optcatalog.ui.theme.outlineDarkHighContrast
import com.optcatalog.ui.theme.outlineDarkMediumContrast
import com.optcatalog.ui.theme.outlineLight
import com.optcatalog.ui.theme.outlineLightHighContrast
import com.optcatalog.ui.theme.outlineLightMediumContrast
import com.optcatalog.ui.theme.outlineVariantDark
import com.optcatalog.ui.theme.outlineVariantDarkHighContrast
import com.optcatalog.ui.theme.outlineVariantDarkMediumContrast
import com.optcatalog.ui.theme.outlineVariantLight
import com.optcatalog.ui.theme.outlineVariantLightHighContrast
import com.optcatalog.ui.theme.outlineVariantLightMediumContrast
import com.optcatalog.ui.theme.primaryContainerDark
import com.optcatalog.ui.theme.primaryContainerDarkHighContrast
import com.optcatalog.ui.theme.primaryContainerDarkMediumContrast
import com.optcatalog.ui.theme.primaryContainerLight
import com.optcatalog.ui.theme.primaryContainerLightHighContrast
import com.optcatalog.ui.theme.primaryContainerLightMediumContrast
import com.optcatalog.ui.theme.primaryDark
import com.optcatalog.ui.theme.primaryDarkHighContrast
import com.optcatalog.ui.theme.primaryDarkMediumContrast
import com.optcatalog.ui.theme.primaryLight
import com.optcatalog.ui.theme.primaryLightHighContrast
import com.optcatalog.ui.theme.primaryLightMediumContrast
import com.optcatalog.ui.theme.scrimDark
import com.optcatalog.ui.theme.scrimDarkHighContrast
import com.optcatalog.ui.theme.scrimDarkMediumContrast
import com.optcatalog.ui.theme.scrimLight
import com.optcatalog.ui.theme.scrimLightHighContrast
import com.optcatalog.ui.theme.scrimLightMediumContrast
import com.optcatalog.ui.theme.secondaryContainerDark
import com.optcatalog.ui.theme.secondaryContainerDarkHighContrast
import com.optcatalog.ui.theme.secondaryContainerDarkMediumContrast
import com.optcatalog.ui.theme.secondaryContainerLight
import com.optcatalog.ui.theme.secondaryContainerLightHighContrast
import com.optcatalog.ui.theme.secondaryContainerLightMediumContrast
import com.optcatalog.ui.theme.secondaryDark
import com.optcatalog.ui.theme.secondaryDarkHighContrast
import com.optcatalog.ui.theme.secondaryDarkMediumContrast
import com.optcatalog.ui.theme.secondaryLight
import com.optcatalog.ui.theme.secondaryLightHighContrast
import com.optcatalog.ui.theme.secondaryLightMediumContrast
import com.optcatalog.ui.theme.surfaceBrightDark
import com.optcatalog.ui.theme.surfaceBrightDarkHighContrast
import com.optcatalog.ui.theme.surfaceBrightDarkMediumContrast
import com.optcatalog.ui.theme.surfaceBrightLight
import com.optcatalog.ui.theme.surfaceBrightLightHighContrast
import com.optcatalog.ui.theme.surfaceBrightLightMediumContrast
import com.optcatalog.ui.theme.surfaceContainerDark
import com.optcatalog.ui.theme.surfaceContainerDarkHighContrast
import com.optcatalog.ui.theme.surfaceContainerDarkMediumContrast
import com.optcatalog.ui.theme.surfaceContainerHighDark
import com.optcatalog.ui.theme.surfaceContainerHighDarkHighContrast
import com.optcatalog.ui.theme.surfaceContainerHighDarkMediumContrast
import com.optcatalog.ui.theme.surfaceContainerHighLight
import com.optcatalog.ui.theme.surfaceContainerHighLightHighContrast
import com.optcatalog.ui.theme.surfaceContainerHighLightMediumContrast
import com.optcatalog.ui.theme.surfaceContainerHighestDark
import com.optcatalog.ui.theme.surfaceContainerHighestDarkHighContrast
import com.optcatalog.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.optcatalog.ui.theme.surfaceContainerHighestLight
import com.optcatalog.ui.theme.surfaceContainerHighestLightHighContrast
import com.optcatalog.ui.theme.surfaceContainerHighestLightMediumContrast
import com.optcatalog.ui.theme.surfaceContainerLight
import com.optcatalog.ui.theme.surfaceContainerLightHighContrast
import com.optcatalog.ui.theme.surfaceContainerLightMediumContrast
import com.optcatalog.ui.theme.surfaceContainerLowDark
import com.optcatalog.ui.theme.surfaceContainerLowDarkHighContrast
import com.optcatalog.ui.theme.surfaceContainerLowDarkMediumContrast
import com.optcatalog.ui.theme.surfaceContainerLowLight
import com.optcatalog.ui.theme.surfaceContainerLowLightHighContrast
import com.optcatalog.ui.theme.surfaceContainerLowLightMediumContrast
import com.optcatalog.ui.theme.surfaceContainerLowestDark
import com.optcatalog.ui.theme.surfaceContainerLowestDarkHighContrast
import com.optcatalog.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.optcatalog.ui.theme.surfaceContainerLowestLight
import com.optcatalog.ui.theme.surfaceContainerLowestLightHighContrast
import com.optcatalog.ui.theme.surfaceContainerLowestLightMediumContrast
import com.optcatalog.ui.theme.surfaceDark
import com.optcatalog.ui.theme.surfaceDarkHighContrast
import com.optcatalog.ui.theme.surfaceDarkMediumContrast
import com.optcatalog.ui.theme.surfaceDimDark
import com.optcatalog.ui.theme.surfaceDimDarkHighContrast
import com.optcatalog.ui.theme.surfaceDimDarkMediumContrast
import com.optcatalog.ui.theme.surfaceDimLight
import com.optcatalog.ui.theme.surfaceDimLightHighContrast
import com.optcatalog.ui.theme.surfaceDimLightMediumContrast
import com.optcatalog.ui.theme.surfaceLight
import com.optcatalog.ui.theme.surfaceLightHighContrast
import com.optcatalog.ui.theme.surfaceLightMediumContrast
import com.optcatalog.ui.theme.surfaceVariantDark
import com.optcatalog.ui.theme.surfaceVariantDarkHighContrast
import com.optcatalog.ui.theme.surfaceVariantDarkMediumContrast
import com.optcatalog.ui.theme.surfaceVariantLight
import com.optcatalog.ui.theme.surfaceVariantLightHighContrast
import com.optcatalog.ui.theme.surfaceVariantLightMediumContrast
import com.optcatalog.ui.theme.tertiaryContainerDark
import com.optcatalog.ui.theme.tertiaryContainerDarkHighContrast
import com.optcatalog.ui.theme.tertiaryContainerDarkMediumContrast
import com.optcatalog.ui.theme.tertiaryContainerLight
import com.optcatalog.ui.theme.tertiaryContainerLightHighContrast
import com.optcatalog.ui.theme.tertiaryContainerLightMediumContrast
import com.optcatalog.ui.theme.tertiaryDark
import com.optcatalog.ui.theme.tertiaryDarkHighContrast
import com.optcatalog.ui.theme.tertiaryDarkMediumContrast
import com.optcatalog.ui.theme.tertiaryLight
import com.optcatalog.ui.theme.tertiaryLightHighContrast
import com.optcatalog.ui.theme.tertiaryLightMediumContrast


private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}