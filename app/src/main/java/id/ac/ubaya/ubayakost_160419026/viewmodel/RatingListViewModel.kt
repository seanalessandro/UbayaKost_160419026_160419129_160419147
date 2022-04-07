package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.ubayakost_160419026.model.Rating

class RatingListViewModel(application: Application) : AndroidViewModel(application){
    val ratingsLD = MutableLiveData<List<Rating>>()
    val ratingsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val tag = "volleyTag"
    private var queue: RequestQueue? = null
    fun refresh(){

        loadingLD.value = true
        ratingsLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://api.npoint.io/3b385aad0e2869e0b06f"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Rating>>() {}.type
                val result = Gson().fromJson<ArrayList<Rating>>(it, sType)
                ratingsLD.value = result
                loadingLD.value = false
                Log.d("showvolley", it)
            },
            {
                Log.d("showvolley", it.toString())
                ratingsLoadErrorLD.value = false
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