package id.ac.ubaya.ubayakost_160419026.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.ubayakost_160419026.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnKeamananData.setOnClickListener{
            val action = HomeFragmentDirections.actionKeamananData()
            Navigation.findNavController(it).navigate(action)
        }

        btnKetentuan.setOnClickListener {
            val action = HomeFragmentDirections.actionKetentuan()
            Navigation.findNavController(it).navigate(action)
        }

        btnCredit.setOnClickListener{
            val action = HomeFragmentDirections.actionCredit()
            Navigation.findNavController(it).navigate(action)
        }

        btnDisclaimer.setOnClickListener {
            val action = HomeFragmentDirections.actionDisclaimer()
            Navigation.findNavController(it).navigate(action)
        }

        btnUser.setOnClickListener {
            val action = HomeFragmentDirections.actionListUser()
            Navigation.findNavController(it).navigate(action)
        }
    }

}