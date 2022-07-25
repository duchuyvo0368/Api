package com.voduchuy.getapi.adapter

import android.app.Activity
import android.content.Context
import android.transition.CircularPropagation
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.voduchuy.getapi.R
import com.voduchuy.getapi.api.ApiUtils
import com.voduchuy.getapi.api.Service
import com.voduchuy.getapi.databinding.ActivityMainBinding
import com.voduchuy.getapi.databinding.ItemViewBinding
import com.voduchuy.getapi.model.UsersItem
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdapterUser :
    RecyclerView.Adapter<AdapterUser.ViewHolder>() {
    val listUser = mutableListOf<UsersItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding:ItemViewBinding= ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usersItem:UsersItem= listUser[position]
        holder.tvName.text=usersItem.name
        holder.tvMobile.text=usersItem.mobile
        holder.tvEmail.text=usersItem.email
        Glide.with(holder.itemView).load(usersItem.getImage())
            .error(R.mipmap.ic_launcher).into(holder.profile)
        holder.btnDelete.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }


    class ViewHolder (private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){
        val tvName:TextView=binding.tvName
        val tvMobile:TextView=binding.tvMobile
        val tvEmail:TextView=binding.tvEmail
        val profile:CircleImageView=binding.profileImage
        var btnDelete:Button=binding.btnDelete


    }
/*   override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val strSearch: String = constraint.toString()
                listUserOld=getDataSearch(strSearch)
                return f

            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                notifyDataSetChanged()
            }

        }
    }
    private fun getDataSearch(name:String): List<UsersItem> {
        val dataService: Service = ApiUtils.getDataService()
        val callback: Call<List<UsersItem>> = dataService.getSearch(name)
        callback.enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                val listUser: ArrayList<UsersItem> = response.body() as ArrayList<UsersItem>
//                binding.listItem.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.listItem.adapter = AdapterUser(listUser)
                Log.d("BBB", "$listUser")
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })
    }*/
}
