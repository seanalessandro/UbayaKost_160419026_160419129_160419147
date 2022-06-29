package id.ac.ubaya.ubayakost_160419026.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.databinding.FragmentKostDetailBinding
import id.ac.ubaya.ubayakost_160419026.util.loadImage
import id.ac.ubaya.ubayakost_160419026.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_kost_detail.*

class KostDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dB: FragmentKostDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dB = DataBindingUtil.inflate<FragmentKostDetailBinding>(inflater, R.layout.fragment_kost_detail, container, false)
        // Inflate the layout for this fragment
        return dB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(arguments != null){
            val kostId = KostDetailFragmentArgs.fromBundle(requireArguments()).kostId
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.refresh(kostId)

        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.kostDetailLD.observe(viewLifecycleOwner, Observer {
            dB.kostDetail = it
        })
    }
}