package com.example.strokepatientsvoicerecoveryapp


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ActionBarContextView
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.basic_information.*
import kotlinx.android.synthetic.main.registerlogin.*


class BasicinformationActivity : AppCompatActivity() {

    private lateinit var edusername : EditText
    private lateinit var edpassword : EditText




    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_information)

//        getPassedUser()

        //當按下送出鍵就會跳轉到主題選擇畫面
        send.setOnClickListener {

            saveUserData()
            getPassedUser()
//            val intent = Intent(this,MainoptionActivity::class.java);
//            startActivity(intent)
        }
    }

    // ========================function======================================
    // 上一個頁面傳過來的帳號
    // 現在登入的帳號
    private fun getPassedUser(){

        val intent = getIntent();

        // 有資料就放格子
        val nameUser = intent.getStringExtra("name");
        val emailUser = intent.getStringExtra("email");
        val usernameUser = intent.getStringExtra("username");
        val passwordUser = intent.getStringExtra("password");


        findViewById<TextView>(R.id.test).text = intent.getStringExtra("username")
    }

    // 儲存帳號資料到FireBase
    private fun saveUserData(){

    }
}