package id.ac.ubaya.ubayakost_160419026.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.databinding.RatingListItemBinding
import id.ac.ubaya.ubayakost_160419026.model.Rating
import kotlinx.android.synthetic.main.rating_list_item.view.*

class RatingListAdapter (val ratingList:ArrayList<Rating>) : RecyclerView.Adapter<RatingListAdapter.RatingViewHolder>() {
    class RatingViewHolder(var view: RatingListItemBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RatingListItemBinding>(inflater, R.layout.rating_list_item, parent, false)

        return RatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.view.rating = ratingList[position]
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

