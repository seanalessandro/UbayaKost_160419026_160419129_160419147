package id.ac.ubaya.ubayakost_160419026.model

import androidx.room.*

@Dao
interface RatingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg rating:Rating)

    @Query("SELECT * FROM rating")
    suspend fun selectAllRating(): List<Rating>

    @Query("SELECT * FROM rating WHERE idRating= :id")
    suspend fun selectRating(id:Int): Rating

    @Delete
    suspend fun deleteRating(rating:Rating)
}