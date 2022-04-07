package id.ac.ubaya.ubayakost_160419026.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.model.Rating
import kotlinx.android.synthetic.main.rating_list_item.view.*

class RatingListAdapter (val ratingList:ArrayList<Rating>) : RecyclerView.Adapter<RatingListAdapter.RatingViewHolder>() {
    class RatingViewHolder(var view: View) :
        RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingListAdapter.RatingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rating_list_item, parent, false)

        return RatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.view.txtRatingKomentar.text = ratingList[position].komentar
        holder.view.txtRatingNamaKos.text =  ratingList[position].namaKos
        holder.view.txtRatingPemberiRating.text = ratingList[position].pemberiRating
        holder.view.txtRatingRating.text = "(" +ratingList[position].rating + ")"
    }

    override fun getItemCount(): Int {
        return ratingList.size
    }

    fun updateRatingList(newRatingList: List<Rating>){
        ratingList.clear()
        ratingList.addAll(newRatingList)
        notifyDataSetChanged()
    }
}

