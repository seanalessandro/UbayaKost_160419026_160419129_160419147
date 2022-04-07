package id.ac.ubaya.ubayakost_160419026.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.viewmodel.RatingListViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_rating.*

class RatingFragment : Fragment() {
    private lateinit var viewModel: RatingListViewModel
    private val ratingListAdapter = RatingListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(RatingListViewModel::class.java)
        viewModel.refresh()

        recViewRating.layoutManager = LinearLayoutManager(context)
        recViewRating.adapter = ratingListAdapter

        observerViewModel()

        refreshLayout.setOnRefreshListener {
            recViewRating.visibility = View.GONE
            txtErrorRating.visibility = View.GONE
            progressLoadingRating.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }

    fun observerViewModel(){
        viewModel.ratingsLD.observe(viewLifecycleOwner, Observer {
            ratingListAdapter.updateRatingList(it)
        })

        viewModel.ratingsLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true){
                txtErrorRating.visibility = View.VISIBLE
            } else {
                txtErrorRating.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true){
                recViewRating.visibility = View.GONE
                progressLoadingRating.visibility = View.VISIBLE
            } else {
                recViewRating.visibility = View.VISIBLE
                progressLoadingRating.visibility = View.GONE
            }
        })
    }
}