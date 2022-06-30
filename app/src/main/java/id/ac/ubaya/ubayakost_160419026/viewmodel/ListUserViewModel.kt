package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.ac.ubaya.ubayakost_160419026.model.User
import id.ac.ubaya.ubayakost_160419026.model.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListUserViewModel(application: Application) :AndroidViewModel(application), CoroutineScope {

    val userLD = MutableLiveData<List<User>>()
    val userLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = true
        userLoadErrorLD.value = false
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                UserDatabase::class.java, "newuserdb").build()

            userLD.value = db.userDao().selectAllUser()
        }
    }

    fun clearTask(user: User) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                UserDatabase::class.java, "newuserdb").build()
            db.userDao().deleteUser(user)

            userLD.value = db.userDao().selectAllUser()
        }
    }
}