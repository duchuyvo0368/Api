package com.voduchuy.getapi.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.voduchuy.getapi.MainActivity

import kotlin.math.sqrt

class HelperUser(
    context: Context?,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        val query: String = "CREATE TABLE Users(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name VARCHAR(200)," +
                "Mobile VARCHAR(200)," +
                "Email VARCHAR(200)," +
                "Title VARCHAR(200))"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Users")
        onCreate(db)
    }

    fun addUser(name: String, mobile: String, email: String, title: String) {
        val db: SQLiteDatabase = this.writableDatabase
        val cv = ContentValues()
        cv.put("Name", name)
        cv.put("Mobile", mobile)
        cv.put("Email", email)
        cv.put("Title", title)
        db.insert("Users", null, cv)
    }

    fun getUser(query:String): Cursor {

        val db: SQLiteDatabase = readableDatabase
        var cursor: Cursor? = null
        cursor = db.rawQuery(query, null)
        return cursor
    }

}