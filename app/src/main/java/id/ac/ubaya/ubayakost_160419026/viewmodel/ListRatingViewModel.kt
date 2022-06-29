package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.ac.ubaya.ubayakost_160419026.model.Rating
import id.ac.ubaya.ubayakost_160419026.model.RatingDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListRatingViewModel(application: Application)
    :AndroidViewModel(application), CoroutineScope  {

    val ratingLD = MutableLiveData<List<Rating>>()
    val ratingLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = true
        ratingLoadErrorLD.value = false
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                RatingDatabase::class.java, "newratingdb").build()

            ratingLD.value = db.ratingDao().selectAllRating()
        }
    }

    fun clearTask(rating: Rating) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                RatingDatabase::class.java, "newratingdb").build()
            db.ratingDao().deleteRating(rating)

            ratingLD.value = db.ratingDao().selectAllRating()
        }
    }

}