package com.voduchuy.getapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.voduchuy.getapi.database.HelperUser
import com.voduchuy.getapi.databinding.ActivityAddUsersBinding


class AddUsers : AppCompatActivity() {
    private lateinit var binding: ActivityAddUsersBinding
    lateinit var helperUser: HelperUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            setData()

        }
    }

    private fun setData() {
        helperUser = HelperUser(this, "GetApi.sqlite", null, 1)
        val name: String = binding.tvName.text.toString()
        val userName: String = binding.tvUsername.text.toString()
        val mobile: String = binding.tvMobile.text.toString()
        val workEmail: String = binding.workEmail.text.toString()
        val personalEmail: String = binding.tvPersonalEmail.text.toString()
        val company: String = binding.tvCompany.text.toString()
        val jobTitle: String = binding.jobTitle.text.toString()
        helperUser.queryData("INSERT INTO Users VALUES(null,'$name','$userName','$mobile','$workEmail','$personalEmail','$company','$jobTitle')")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}