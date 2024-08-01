package com.example.fill_plus.my

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.fill_plus.R
import com.example.fill_plus.alarm.AlarmActivity
import com.example.fill_plus.main.MainActivity10

class MyActivity1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmy3)

        val button1 = findViewById<Button>(R.id.건성) // 버튼 객체 가져오기
        val button2 = findViewById<Button>(R.id.중성) // 버튼 객체 가져오기


        button1.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button2.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }


    }
}