package com.example.strokepatientsvoicerecoveryapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TradionalActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.traditional)

        val layout = findViewById<View>(R.id.lamp)
        val foodd= findViewById<View>(R.id.food)// 取得 layout 的參考

        layout.setOnClickListener {
            if (layout.visibility == View.VISIBLE) {
                foodd.visibility = View.INVISIBLE // 如果 layout 目前是可見的，則切換為不可見
            } else {
                layout.visibility = View.VISIBLE // 如果 layout 目前是不可見的，則切換為可見
            }
        }
        foodd.setOnClickListener {
            if (foodd.visibility == View.VISIBLE) {
                layout.visibility = View.INVISIBLE// 如果 layout 目前是可見的，則切換為不可見
            } else {
                foodd.visibility = View.VISIBLE // 如果 layout 目前是不可見的，則切換為可見
            }
        }



    }
}