package com.bsuir.wikipedia.sources.backend

import com.bsuir.wikipedia.sources.model.AppSource
import com.bsuir.wikipedia.sources.model.RetrofitAppSource

class RetrofitSourcesProvider(
    private val config: RetrofitConfig
) : SourcesProvider {

    override fun getAppSource(): AppSource {
        return RetrofitAppSource(config)
    }

}