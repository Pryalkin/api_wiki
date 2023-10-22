package com.bsuir.wikipedia

import android.content.Context
import com.bsuir.wikipedia.app.repository.AppRepository
import com.bsuir.wikipedia.app.setting.AppSettings
import com.bsuir.wikipedia.app.setting.SharedPreferencesAppSettings
import com.bsuir.wikipedia.sources.SourceProviderHolder
import com.bsuir.wikipedia.sources.backend.SourcesProvider
import com.bsuir.wikipedia.sources.model.AppSource
import com.bsuir.wikipedia.app.views.AppViewModel


object Singletons {

    private lateinit var appContext: Context

    private val sourcesProvider: SourcesProvider by lazy {
        SourceProviderHolder.sourcesProvider
    }

    val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(appContext)
    }

    // source
    private val appSource: AppSource by lazy {
        sourcesProvider.getAppSource()
    }

    // repository
    val appRepository: AppRepository by lazy {
        AppRepository(
            appSource = appSource
        )
    }

    // viewModel

    val appViewModel: AppViewModel by lazy {
        AppViewModel()
    }

    fun init(appContext: Context) {
        Singletons.appContext = appContext
    }

}