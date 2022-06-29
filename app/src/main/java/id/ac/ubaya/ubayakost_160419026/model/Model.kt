package id.ac.ubaya.ubayakost_160419026.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Kost(
    @ColumnInfo(name="nama")
    var nama:String?,
    @ColumnInfo(name="ukuran")
    var ukuran:String?,
    @ColumnInfo(name="kamarMandi")
    var kamarMandi:String?,
    @ColumnInfo(name="lokasi")
    var lokasi:String?,
    @ColumnInfo(name="keterangan")
    var keterangan:String?,
    @ColumnInfo(name="harga")
    var harga:String?,
    @ColumnInfo(name="urlFoto")
    var urlFoto:String?,
    @ColumnInfo(name="jarak")
    var jarak:String?
){
    @PrimaryKey(autoGenerate = true)
    var idKost:Int=0
}

@Entity
data class Rating(
    @ColumnInfo(name="namaKos")
    var namaKos:String?,
    @ColumnInfo(name="pemberiRating")
    var pemberiRating:String?,
    @ColumnInfo(name="rating")
    var rating:String?,
    @ColumnInfo(name="komentar")
    var komentar:String?,
){
    @PrimaryKey(autoGenerate = true)
    var idRating:Int=0
}

@Entity
data class Reviewer(
    @ColumnInfo(name="namaReviewer")
    var namaReviewer:String?,
    @ColumnInfo(name="noHp")
    var noHp:String?,
    @ColumnInfo(name="alamat")
    var alamat:String?,
){
    @PrimaryKey(autoGenerate = true)
    var idReviewer:Int=0
}

@Entity
data class User(
    @ColumnInfo(name="username")
    var username:String?,
    @ColumnInfo(name="email")
    var email:String?,
    @ColumnInfo(name="password")
    var password:String?,
){
    @PrimaryKey(autoGenerate = true)
    var idUser:Int=0
}