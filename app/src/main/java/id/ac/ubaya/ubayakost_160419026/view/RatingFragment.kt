package id.ac.ubaya.ubayakost_160419026.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.viewmodel.ListRatingViewModel
import kotlinx.android.synthetic.main.fragment_rating.*

class RatingFragment : Fragment() {
    private lateinit var viewModel: ListRatingViewModel
    private val ratingListAdapter = RatingListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ListRatingViewModel::class.java)
        viewModel.refresh()

        recViewRating.layoutManager = LinearLayoutManager(context)
        recViewRating.adapter = ratingListAdapter

        fabAddRating.setOnClickListener {
            val action = RatingFragmentDirections.actionCreateRating()
            Navigation.findNavController(it).navigate(action)
        }

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.ratingLD.observe(viewLifecycleOwner, Observer {
            ratingListAdapter.updateRatingList(it)
            if(it.isEmpty()) {
                txtEmptyRating.visibility = View.VISIBLE
            } else {
                txtEmptyRating.visibility = View.GONE
            }
        })
    }
}