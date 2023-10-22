package com.bsuir.wikipedia.sources.backend

import com.bsuir.wikipedia.sources.model.AppSource

interface SourcesProvider {

    fun getAppSource(): AppSource

}