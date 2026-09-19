package com.kei.pulse.i18n

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.Locale

val LocalPulseStrings = staticCompositionLocalOf<PulseStrings> { ZhTwStrings }

fun resolvePulseStrings(language: AppLanguage): PulseStrings {
    return when (language) {
        AppLanguage.SYSTEM -> {
            val locale = Locale.getDefault()
            val lang = locale.language
            if (lang.equals("zh", ignoreCase = true)) {
                ZhTwStrings
            } else {
                EnStrings
            }
        }
        AppLanguage.ZH_TW -> ZhTwStrings
        AppLanguage.EN -> EnStrings
    }
}

@Composable
fun ProvidePulseStrings(language: AppLanguage, content: @Composable () -> Unit) {
    val strings = resolvePulseStrings(language)
    CompositionLocalProvider(LocalPulseStrings provides strings) {
        content()
    }
}
