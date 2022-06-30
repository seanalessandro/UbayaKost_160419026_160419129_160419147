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
import id.ac.ubaya.ubayakost_160419026.viewmodel.ListUserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : Fragment() {
    private lateinit var viewModel:ListUserViewModel
    private val userListAdapter  = UserListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListUserViewModel::class.java)
        viewModel.refresh()
        recViewUser.layoutManager = LinearLayoutManager(context)
        recViewUser.adapter = userListAdapter

        fabAddUser.setOnClickListener {
            val action = UserListFragmentDirections.actionRegisterUser()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            userListAdapter.updateUserList(it)
            if(it.isEmpty()) {
                txtEmptyUser.visibility = View.VISIBLE
            } else {
                txtEmptyUser.visibility = View.GONE
            }
        })
    }

}