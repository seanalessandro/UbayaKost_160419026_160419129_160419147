package id.ac.ubaya.ubayakost_160419026.model

import androidx.room.*

@Dao
interface ReviewerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg reviewer:Reviewer)

    @Query("SELECT * FROM reviewer")
    suspend fun selectAllReviewer(): List<Reviewer>

    @Query("SELECT * FROM reviewer WHERE idReviewer =:id")
    suspend fun selectReviewer(id:Int): Reviewer

    @Delete
    suspend fun deleteReviewer(reviewer: Reviewer)
}