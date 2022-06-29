package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.ubayakost_160419026.model.Kost
import id.ac.ubaya.ubayakost_160419026.model.KostDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addKost(list:List<Kost>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), KostDatabase::class.java,
                "newkostdb").build()
            db.kostDao().insertAll(*list.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}