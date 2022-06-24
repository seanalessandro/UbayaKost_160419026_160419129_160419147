package id.ac.ubaya.ubayakost_160419026.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Reviewer::class), version = 1)
abstract class ReviewerDatabase:RoomDatabase() {
    abstract fun reviewerDao(): ReviewerDao

    companion object{
        @Volatile private var instance: ReviewerDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(context.applicationContext,
            ReviewerDatabase::class.java, "newreviewerdb").build()

        operator fun invoke(context: Context){
            if(instance!=null){
                synchronized(LOCK){
                    instance ?: buildDatabase(context).also{
                        instance = it
                    }
                }
            }
        }
    }
}