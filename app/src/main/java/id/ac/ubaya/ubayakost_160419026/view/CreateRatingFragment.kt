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
import id.ac.ubaya.ubayakost_160419026.model.Rating
import id.ac.ubaya.ubayakost_160419026.viewmodel.DetailRatingViewModel
import kotlinx.android.synthetic.main.fragment_create_rating.*

class CreateRatingFragment : Fragment() {
    private lateinit var viewModel:DetailRatingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(DetailRatingViewModel::class.java)

        btnAddRating.setOnClickListener {
            var rating = Rating(txtInputNamaKosRating.text.toString(), txtInputNamaPenggunaRating.text.toString(),
            txtInputRatingRating.text.toString(), txtInputKomentarRating.text.toString())
            val list = listOf(rating)
            viewModel.addRating(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

}