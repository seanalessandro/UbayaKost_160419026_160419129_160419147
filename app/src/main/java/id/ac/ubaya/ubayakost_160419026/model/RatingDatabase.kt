package id.ac.ubaya.ubayakost_160419026.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Rating::class), version = 1)
abstract class RatingDatabase:RoomDatabase() {
    abstract fun ratingDao(): RatingDao

    companion object {
        @Volatile private var instance: RatingDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                RatingDatabase::class.java,"newratingdb"
            ).build()

        operator fun invoke(context: Context){
            if(instance!=null){
                synchronized(LOCK){
                    instance?: buildDatabase(context).also{
                        instance = it
                    }
                }
            }
        }
    }
}