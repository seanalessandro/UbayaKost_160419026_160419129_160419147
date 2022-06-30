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
import id.ac.ubaya.ubayakost_160419026.model.User
import id.ac.ubaya.ubayakost_160419026.viewmodel.DetailUserViewModel
import kotlinx.android.synthetic.main.fragment_register_user.*
import kotlinx.android.synthetic.main.user_list_item.*

class RegisterUserFragment : Fragment() {
    private lateinit var viewModel:DetailUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(DetailUserViewModel::class.java)

        btnRegister.setOnClickListener {
            if (txtPasswordRegister.text.toString() == txtRePasswordRegister.text.toString())
            {
                var user = User(txtUsernameRegister.text.toString(), txtEmailRegister.text.toString(), txtPasswordRegister.text.toString())
                val list = listOf(user)
                viewModel.addUser(list)
                Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
                Navigation.findNavController(it).popBackStack()
            } else {
                Toast.makeText(view.context, "Pastikan Password sama dengan Re-Enter Password", Toast.LENGTH_LONG).show()
            }
        }
    }

}