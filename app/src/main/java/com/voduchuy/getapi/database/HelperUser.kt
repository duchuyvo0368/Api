package com.voduchuy.getapi.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperUser(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun queryData(sql:String){
        val database:SQLiteDatabase=writableDatabase
        database.execSQL(sql)
    }
    fun getData(sql:String):Cursor{
        val database:SQLiteDatabase=readableDatabase
        return database.rawQuery(sql,null)
    }

}