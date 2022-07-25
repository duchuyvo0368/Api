package com.voduchuy.getapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.voduchuy.getapi.database.HelperUser
import com.voduchuy.getapi.databinding.ActivityAddUsersBinding


class AddUsers : AppCompatActivity() {
    private lateinit var binding: ActivityAddUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            addData()
        }
    }

    private fun addData() {
        val name=binding.edtName.text.toString().trim()
        val mobile=binding.edtMobile.text.toString()
        val email=binding.edtEmail.text.toString()
        val title=binding.edtTitle.text.toString()
        val helperUser = HelperUser(this, "GetApi.sqlite", null, 1)
        helperUser.addUser(name, mobile,email,title)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}