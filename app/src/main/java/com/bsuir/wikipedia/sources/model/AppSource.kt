package com.bsuir.wikipedia.sources.model

import com.bsuir.wikipedia.app.model.item.WikiQueryResponse
import com.bsuir.wikipedia.app.model.list.Obj
import retrofit2.Response

interface AppSource {
    suspend fun getAll(srsearch: String): Response<Obj>
    suspend fun getItem(titles: String): Response<WikiQueryResponse>
}