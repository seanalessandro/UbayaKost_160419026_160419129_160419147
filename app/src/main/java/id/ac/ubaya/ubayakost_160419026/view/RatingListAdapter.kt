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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rating_list_item, parent, false)

        return RatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.view.txtRatingNamaKos.setText(ratingList[position].namaKos.toString())
        holder.view.txtRatingKomentar.setText(ratingList[position].komentar.toString())
        holder.view.txtRatingPemberiRating.setText(ratingList[position].pemberiRating.toString())
        holder.view.txtRatingRating.setText("("+ratingList[position].rating.toString()+")")
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

