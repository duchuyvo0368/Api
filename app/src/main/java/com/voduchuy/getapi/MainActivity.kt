package com.voduchuy.getapi

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.voduchuy.getapi.adapter.AdapterUser
import com.voduchuy.getapi.database.HelperUser
import com.voduchuy.getapi.databinding.ActivityMainBinding
import com.voduchuy.getapi.model.UsersItem

class MainActivity : AppCompatActivity() {
    lateinit var helper: HelperUser
    //var listUser: List<UsersItem> = ArrayList()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newDatabase()
        setUpView()
        clickAdd()
        getData()

    }


    private fun newDatabase() {
        helper = HelperUser(this, "GetApi.sqlite", null, 1)
        helper.queryData("CREATE TABLE IF NOT EXISTS Users(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(200),UserName VARCHAR(200), Mobile VARCHAR(200),WorkEmail VARCHAR(200),PersonalEmail VARCHAR(200),Company VARCHAR(200),JobTitle VARCHAR(200))")
       // helper.queryData("INSERT INTO Users VALUES(null,'HUY','VODUCHUY','0123','voduchuy@gmail.coml','voduchuy','huy','vohuy')")
    }

    private fun clickAdd() {
        binding.bntAdd.setOnClickListener {
            val intent = Intent(this, AddUsers::class.java)
            startActivity(intent)
        }
    }

    private fun setUpView() {
        adapter = AdapterUser()
        binding.listItem.layoutManager = LinearLayoutManager(this)
        adapter.listUser.clear()
        binding.listItem.adapter = adapter
    }
    private fun getData(){

        val dataUser:Cursor=helper.getData("SELECT * FROM Users")
        while (dataUser.moveToNext()){
            val id:Int=dataUser.getInt(0)
            val name:String=dataUser.getString(1)
            val userName:String=dataUser.getString(2)
            val mobile:String=dataUser.getString(3)
            val workEmail:String=dataUser.getString(4)
            val personalEmail:String=dataUser.getString(5)
            val company:String=dataUser.getString(6)
            val jobTitle:String=dataUser.getString(7)
            val usersItem=UsersItem(id,name, userName,mobile,workEmail,personalEmail,company,jobTitle)
            adapter.listUser.add(usersItem)
            adapter.notifyDataSetChanged()
            Log.d("AAA","$usersItem")
        }
    }
    /*  private fun getData() {
          val dataService: Service = ApiUtils.getDataService()
          val callback: Call<List<UsersItem>> = dataService.getUser()
          callback.enqueue(object : Callback<List<UsersItem>> {
              override fun onResponse(
                  call: Call<List<UsersItem>>,
                  response: Response<List<UsersItem>>
              ) {
                  val listUser: ArrayList<UsersItem> = response.body() as ArrayList<UsersItem>
                  adapter.listUser.clear()
                  adapter.listUser.addAll(listUser)
                  adapter.notifyDataSetChanged()

              }

              override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

              }

          })
      }*/

    /*private fun getDataSearch(name: String) {
        val dataService: Service = ApiUtils.getDataService()
        val callback: Call<List<UsersItem>> = dataService.getSearch(name)
        callback.enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                val listUser: ArrayList<UsersItem> = response.body() as ArrayList<UsersItem>
                adapter.listUser.clear()
                adapter.listUser.addAll(listUser)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }

        })
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchManager: SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = menu!!.findItem(R.id.action_search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                   // getDataSearch(query)
                }
//               adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              //  getData()
                return false
            }
        })
        return true
    }
}