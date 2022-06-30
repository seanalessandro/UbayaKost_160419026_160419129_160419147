package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.ac.ubaya.ubayakost_160419026.model.Kost
import id.ac.ubaya.ubayakost_160419026.model.KostDatabase
import id.ac.ubaya.ubayakost_160419026.model.User
import id.ac.ubaya.ubayakost_160419026.model.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailUserViewModel(application:  Application) :AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addUser(list:List<User>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), UserDatabase::class.java,
                "newuserdb").build()
            db.userDao().insertAll(*list.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}