package id.ac.ubaya.ubayakost_160419026.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.databinding.KostListItemBinding
import id.ac.ubaya.ubayakost_160419026.model.Kost
import id.ac.ubaya.ubayakost_160419026.util.loadImage
import kotlinx.android.synthetic.main.kost_list_item.view.*

class KostListAdapter(val kostList:ArrayList<Kost>) : RecyclerView.Adapter<KostListAdapter.KostViewHolder>(), ButtonDetailClickListener {
    class KostViewHolder(var view: KostListItemBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.kost_list_item, parent, false)
        val view = DataBindingUtil.inflate<KostListItemBinding>(inflater, R.layout.kost_list_item, parent, false)

        return KostViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostViewHolder, position: Int) {
        holder.view.kost = kostList[position]
        holder.view.listenerDetail = this
//        holder.view.txtNamaKost.text = kostList[position].nama
//        holder.view.txtKeteranganKost.text = kostList[position].keterangan
//        holder.view.imgKost.loadImage(kostList[position].urlFoto, holder.view.progressBarImgKost)
//        holder.view.btnDetailKost.setOnClickListener{
//            val action = ListFragmentDirections.actionKostDetail(kostList[position].idKost)
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {
        return kostList.size
    }

    fun updateKostList(newKostList: List<Kost>){
        kostList.clear()
        kostList.addAll(newKostList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = ListFragmentDirections.actionKostDetail(Integer.parseInt(v.tag.toString()))
        Navigation.findNavController(v).navigate(action)

    }
}