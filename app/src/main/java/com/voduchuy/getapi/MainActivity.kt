package com.voduchuy.getapi

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.voduchuy.getapi.adapter.AdapterUser
import com.voduchuy.getapi.database.HelperUser
import com.voduchuy.getapi.databinding.ActivityMainBinding
import com.voduchuy.getapi.model.UsersItem

class MainActivity : AppCompatActivity() {
    private var helper = HelperUser(this, "GetApi.sqlite", null, 1)
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
        displayData()
        clickAdd()


    }

    private fun displayData() {
        val cursor: Cursor = helper.getUser("SELECT * FROM Users")
        Log.d("Cursor", "$cursor")
        if (cursor.count == 0) {
            Toast.makeText(applicationContext, "No Data", Toast.LENGTH_SHORT).show()
        } else {
            while (cursor.moveToNext()) {
                val id: Int = cursor.getInt(0)
                val name: String = cursor.getString(1)
                val userName: String = cursor.getString(2)
                val mobile: String = cursor.getString(3)
                val workEmail: String = cursor.getString(4)

                val usersItem = UsersItem(
                    id,
                    name,
                    userName,
                    mobile,
                    workEmail
                )
                adapter.listUser.add(usersItem)
                adapter.notifyDataSetChanged()
                Log.d("AAA", "$usersItem")
            }
        }
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

        }
    }*/




