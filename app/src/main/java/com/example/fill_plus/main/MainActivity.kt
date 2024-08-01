package com.example.fill_plus.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.fill_plus.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity5::class.java)//loginActivity1
            startActivity(intent)
            finish() // 현재 액티비티 종료
        }, 1000) // 3초 딜레이
    }

}//loginActivity1