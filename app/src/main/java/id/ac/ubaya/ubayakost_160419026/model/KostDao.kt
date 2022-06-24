package id.ac.ubaya.ubayakost_160419026.model

import androidx.room.*

@Dao
interface KostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg kost: Kost)

    @Query("SELECT * FROM kost")
    suspend fun selectAllKost(): List<Kost>

    @Query("SELECT * FROM kost WHERE idKost= :id")
    suspend fun selectKost(id:Int): Kost

    @Delete
    suspend fun deleteKost(kost: Kost)
}