package com.example.sqlitedemo

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var user:EditText
    private lateinit var pwd:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user=findViewById(R.id.editTextTextPersonName)
        pwd=findViewById(R.id.editTextTextPassword)
        var helper=mydbhelper(applicationContext)
        var db=helper.readableDatabase
        var rs=db.rawQuery("SELECT * FROM USERS",null)
        if (rs.moveToNext())
            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_LONG).show()
        var insert=findViewById<Button>(R.id.button11)
        insert.setOnClickListener {
            check_empty()
var cv=ContentValues()
            cv.put("UNAME",user.text.toString())
            cv.put("PWD",pwd.text.toString())
             db.insert("USERS",null,cv)
            user.setText("")
            pwd.setText("")
            user.requestFocus()


        }



    }

    private fun check_empty(){
        val username=user.text.toString().trim()
        val userpassword=pwd.text.toString().trim()

        if (username.isEmpty()) {
            user.error = "NAME REQUIRED"
            return
        } else
            if (userpassword.isEmpty()) {
                pwd.error = "ID REQUIRED"
                return
            }
    }
}