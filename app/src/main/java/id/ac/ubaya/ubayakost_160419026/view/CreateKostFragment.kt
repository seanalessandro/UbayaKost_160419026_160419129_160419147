package id.ac.ubaya.ubayakost_160419026.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.model.Kost
import id.ac.ubaya.ubayakost_160419026.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_create_kost.*

class CreateKostFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_kost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        btnAddKost.setOnClickListener {
            var kost = Kost(txtNamaKos.text.toString(), txtUkuran.text.toString(), txtKamarMandi.text.toString(), txtLokasi.text.toString(),
                txtKeterangan.text.toString(), txtHarga.text.toString(), txtUrlPhoto.text.toString(), txtJarak.text.toString())
            val list = listOf(kost)
            viewModel.addKost(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

}