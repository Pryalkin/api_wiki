package com.bsuir.wikipedia.sources.model

import com.bsuir.wikipedia.app.model.item.WikiQueryResponse
import com.bsuir.wikipedia.app.model.list.Obj
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("api.php")
    suspend fun getItem(@Query("titles") titles: String,
                        @Query("action") action: String = "query",
                        @Query("prop") prop: String = "info",
                        @Query("format") format: String = "json"): Response<WikiQueryResponse>

    @GET("api.php")
    suspend fun getAll(@Query("srsearch") srsearch: String = "Java",
                       @Query("action") action: String = "query",
                       @Query("list") list: String = "search",
                       @Query("format") format: String = "json"): Response<Obj>


}