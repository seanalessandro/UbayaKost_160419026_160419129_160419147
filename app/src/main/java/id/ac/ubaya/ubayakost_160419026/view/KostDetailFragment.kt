package id.ac.ubaya.ubayakost_160419026.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.util.loadImage
import id.ac.ubaya.ubayakost_160419026.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_kost_detail.*

class KostDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kost_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if(arguments != null){
            var kostId = KostDetailFragmentArgs.fromBundle(requireArguments()).kostId
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.fetch(kostId)
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.kostsLD.observe(viewLifecycleOwner){
            txtDetailNamaKost.setText(viewModel.kostsLD.value?.nama)
            txtDetailKamarMandi.setText(viewModel.kostsLD.value?.kamarMandi)
            txtDetailKeterangan.setText(viewModel.kostsLD.value?.keterangan)
            txtDetailLokasi.setText(viewModel.kostsLD.value?.lokasi)
            txtDetailUkuran.setText(viewModel.kostsLD.value?.ukuran)
            imgDetailKost.loadImage(viewModel.kostsLD.value?.urlFoto, progressLoadingDetail)
        }
    }
}