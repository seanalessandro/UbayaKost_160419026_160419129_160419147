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

class ListViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val kostsLD = MutableLiveData<List<Kost>>()
    val kostsLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = true
        kostsLoadErrorLD.value = false
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                KostDatabase::class.java, "newkostdb").build()

            kostsLD.value = db.kostDao().selectAllKost()
        }
    }

    fun deleteKost(kost: Kost) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                KostDatabase::class.java, "newkostdb").build()
            db.kostDao().deleteKost(kost)

            kostsLD.value = db.kostDao().selectAllKost()
        }
    }


}