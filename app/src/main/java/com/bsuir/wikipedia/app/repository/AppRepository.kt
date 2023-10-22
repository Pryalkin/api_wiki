package com.bsuir.wikipedia.app.repository

import com.bsuir.wikipedia.app.model.item.WikiQueryResponse
import com.bsuir.wikipedia.app.model.list.Obj
import com.bsuir.wikipedia.sources.exception.BackendException
import com.bsuir.wikipedia.sources.exception.InvalidCredentialsException
import com.bsuir.wikipedia.sources.model.AppSource
import retrofit2.Response

class AppRepository(
    private val appSource: AppSource
) {


    suspend fun getAll(srsearch: String): Response<Obj> {
        val res: Response<Obj> = try {
            appSource.getAll(srsearch)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getItem(titles: String): Response<WikiQueryResponse> {
        val res: Response<WikiQueryResponse> = try {
            appSource.getItem(titles)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }


}