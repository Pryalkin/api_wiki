package com.bsuir.wikipedia.sources.model

import com.bsuir.wikipedia.app.model.item.WikiQueryResponse
import com.bsuir.wikipedia.app.model.list.Obj
import com.bsuir.wikipedia.sources.backend.BackendRetrofitSource
import com.bsuir.wikipedia.sources.backend.RetrofitConfig
import kotlinx.coroutines.delay
import retrofit2.Response

class RetrofitAppSource(
    config: RetrofitConfig
) : BackendRetrofitSource(config), AppSource {

    private val appApi = retrofit.create(AppApi::class.java)

    override suspend fun getAll(srsearch: String): Response<Obj> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getAll(srsearch)
    }

    override suspend fun getItem(titles: String): Response<WikiQueryResponse> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getItem(titles)
    }


}