package com.example.sqlitedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class mydbhelper(context: Context) :SQLiteOpenHelper (context,"USERDB",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT,PWD TEXT)")
        db?.execSQL("INSERT INTO USERS(UNAME,PWD)VALUES('KKKKK','POS')")
        db?.execSQL("INSERT INTO USERS(UNAME,PWD)VALUES('JJJ','SOP')")


    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}