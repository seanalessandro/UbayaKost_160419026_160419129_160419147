package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.ubayakost_160419026.model.Kost

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val kostsLD = MutableLiveData<Kost>()
    val kostsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val tag = "volleyTag"
    private var queue: RequestQueue? = null
    fun fetch(kostId: Int){

        loadingLD.value = true
        kostsLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://api.npoint.io/534f5e2ff79d926bec95"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Kost>>() {}.type
                val result = Gson().fromJson<ArrayList<Kost>>(it, sType)
                for(r in result){
                    if (r.idKost == kostId){
                        kostsLD.value = r
                        loadingLD.value = false
                    }
                }
                Log.d("isi r", kostsLD.value.toString())
                Log.d("showvolley", it)
            },
            {
                Log.d("showvolley", it.toString())
                kostsLoadErrorLD.value = false
                loadingLD.value = false
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(tag)
    }
}