package id.ac.ubaya.ubayakost_160419026.model

data class Kost(
    val id:String?,
    val nama:String?,
    val ukuran:String?,
    val kamarMandi:String?,
    val lokasi:String?,
    val keterangan:String?,
    val harga:String?,
    val urlFoto:String?
)

data class Rating(
    val id:String?,
    val namaKos:String?,
    val pemberiRating:String?,
    val rating:String?,
    val komentar:String?,
)