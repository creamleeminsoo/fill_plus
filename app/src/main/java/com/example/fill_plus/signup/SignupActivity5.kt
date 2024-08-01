package com.example.fill_plus.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fill_plus.R
import com.example.fill_plus.main.MainActivity2

class signupActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlog5)

        val 다음 = findViewById<Button>(R.id.다음) // 버튼 객체 가져오기


        다음.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
    }
}