package id.ac.ubaya.ubayakost_160419026.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.ubayakost_160419026.R
import id.ac.ubaya.ubayakost_160419026.databinding.UserListItemBinding
import id.ac.ubaya.ubayakost_160419026.model.User
import kotlinx.android.synthetic.main.user_list_item.view.*

class UserListAdapter(val userList:ArrayList<User>):RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    class UserViewHolder(var view:UserListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<UserListItemBinding>(inflater, R.layout.user_list_item, parent, false)


        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int)
    {
        holder.view.user = userList[position]
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(newUserList: List<User>){
        userList.clear()
        userList.addAll(newUserList)
        notifyDataSetChanged()
    }
}