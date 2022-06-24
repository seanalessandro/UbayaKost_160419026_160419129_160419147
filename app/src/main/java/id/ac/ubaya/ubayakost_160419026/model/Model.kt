package id.ac.ubaya.ubayakost_160419026.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Kost(
    @ColumnInfo(name="nama")
    val nama:String?,
    @ColumnInfo(name="ukuran")
    val ukuran:String?,
    @ColumnInfo(name="kamarMandi")
    val kamarMandi:String?,
    @ColumnInfo(name="lokasi")
    val lokasi:String?,
    @ColumnInfo(name="keterangan")
    val keterangan:String?,
    @ColumnInfo(name="harga")
    val harga:String?,
    @ColumnInfo(name="urlFoto")
    val urlFoto:String?


){
    @PrimaryKey(autoGenerate = true)
    val idKost:Int=0
}

@Entity
data class Rating(
    @ColumnInfo(name="namaKos")
    val namaKos:String?,
    @ColumnInfo(name="pemberiRating")
    val pemberiRating:String?,
    @ColumnInfo(name="rating")
    val rating:String?,
    @ColumnInfo(name="komentar")
    val komentar:String?,
){
    @PrimaryKey(autoGenerate = true)
    val idRating:Int=0
}