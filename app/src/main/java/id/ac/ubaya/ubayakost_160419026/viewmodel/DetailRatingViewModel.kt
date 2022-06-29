package id.ac.ubaya.ubayakost_160419026.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import id.ac.ubaya.ubayakost_160419026.model.Rating
import id.ac.ubaya.ubayakost_160419026.model.RatingDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailRatingViewModel(application:  Application)
    :AndroidViewModel(application), CoroutineScope {
    private val job = Job()

    fun addRating(list: List<Rating>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), RatingDatabase::class.java,
                "newratingdb"
            ).build()
            db.ratingDao().insertAll(*list.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}

