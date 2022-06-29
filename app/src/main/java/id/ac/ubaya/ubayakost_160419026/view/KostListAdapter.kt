package id.ac.ubaya.ubayakost_160419026.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.model.Kost
import id.ac.ubaya.ubayakost_160419026.util.loadImage
import kotlinx.android.synthetic.main.kost_list_item.view.*

class  KostListAdapter(val kostList:ArrayList<Kost>) : RecyclerView.Adapter<KostListAdapter.KostViewHolder>() {
    class KostViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kost_list_item, parent, false)

        return KostViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostViewHolder, position: Int) {
        holder.view.txtNamaKost.setText(kostList[position].nama.toString())
        holder.view.txtHarga.setText(kostList[position].harga.toString())
        holder.view.txtJarak.setText(kostList[position].jarak.toString())
        holder.view.txtKeteranganKost.setText(kostList[position].keterangan.toString())
    }

    override fun getItemCount(): Int {
        return kostList.size
    }

    fun updateKostList(newKostList: List<Kost>){
        kostList.clear()
        kostList.addAll(newKostList)
        notifyDataSetChanged()
    }
}