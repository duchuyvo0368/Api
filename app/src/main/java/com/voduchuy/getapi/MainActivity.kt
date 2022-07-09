package com.voduchuy.getapi

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.voduchuy.getapi.adapter.AdapterUser
import com.voduchuy.getapi.api.ApiUtils
import com.voduchuy.getapi.api.Service
import com.voduchuy.getapi.databinding.ActivityMainBinding
import com.voduchuy.getapi.model.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val dataService: Service = ApiUtils.getDataService()
        val callback: Call<List<UsersItem>> = dataService.getUser()
        callback.enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                val listUser: ArrayList<UsersItem> = response.body() as ArrayList<UsersItem>
                binding.listItem.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.listItem.adapter = AdapterUser(listUser)
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })
    }

    private fun getDataSearch(name:String) {
        val dataService: Service = ApiUtils.getDataService()
        val callback: Call<List<UsersItem>> = dataService.getSearch(name)
        callback.enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                val listUser: ArrayList<UsersItem> = response.body() as ArrayList<UsersItem>
                binding.listItem.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.listItem.adapter = AdapterUser(listUser)
                Log.d("BBB", "$listUser")
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val searchManager:SearchManager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = menu!!.findItem(R.id.action_search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth=Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    getDataSearch(query)
                }
//               adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                getData()
                return false
            }
        })
        return true
    }
}