package com.bsuir.wikipedia.app.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsuir.wikipedia.Singletons
import com.bsuir.wikipedia.app.model.item.WikiQueryResponse
import com.bsuir.wikipedia.app.model.list.Obj
import com.bsuir.wikipedia.app.model.utils.HttpResponse
import com.bsuir.wikipedia.app.repository.AppRepository
import com.bsuir.wikipedia.app.utils.MutableLiveEvent
import com.bsuir.wikipedia.app.utils.publishEvent
import com.bsuir.wikipedia.app.utils.share
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import retrofit2.Response

class AppViewModel  (
    private val appRepository: AppRepository = Singletons.appRepository
): ViewModel() {

    private val _message = MutableLiveEvent<String>()
    val message = _message.share()

    private val _obj = MutableLiveData<Obj>()
    val obj: LiveData<Obj> get() = _obj

    private val _obj2 = MutableLiveData<WikiQueryResponse>()
    val obj2: LiveData<WikiQueryResponse> get() = _obj2

//    private val _w = MutableLiveData<W>()
//    val w: LiveData<W> get() = _w

    private fun showToast(mes: String) = _message.publishEvent(mes)

    fun getAll(srsearch: String) {
        viewModelScope.launch {
            var res: Response<Obj> = appRepository.getAll(srsearch)
            if (res.isSuccessful){
                _obj.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

    fun getItem(titles: String) {
        viewModelScope.launch {
            var res: Response<WikiQueryResponse> = appRepository.getItem(titles)
            if (res.isSuccessful){
                _obj2.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

}