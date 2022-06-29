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
import id.ac.ubaya.ubayakost_160419026.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val kostListAdapter = KostListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = kostListAdapter

        fabAddKost.setOnClickListener {
            val action = ListFragmentDirections.actionCreateKost()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.kostsLD.observe(viewLifecycleOwner, Observer {
            kostListAdapter.updateKostList(it)
            if(it.isEmpty()) {
                txtEmpty.visibility = View.VISIBLE
            } else {
                txtEmpty.visibility = View.GONE
            }
        })
    }
}