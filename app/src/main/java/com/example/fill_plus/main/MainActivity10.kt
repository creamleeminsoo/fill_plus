package com.example.fill_plus.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import com.example.fill_plus.my.MyActivity1
import com.example.fill_plus.R

class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmy)
        val button1 = findViewById<Button>(R.id.건성) // 버튼 객체 가져오기
        val button59 = findViewById<Button>(R.id.button59) //
        val button66 = findViewById<Button>(R.id.button66)
        val button67 = findViewById<Button>(R.id.button67)
        val button68 = findViewById<Button>(R.id.button68)
        val button69 = findViewById<Button>(R.id.button69)
        val button70 = findViewById<Button>(R.id.button70)
        val button71 = findViewById<Button>(R.id.button71)
        val button72 = findViewById<Button>(R.id.button72)
        val button73 = findViewById<Button>(R.id.button73)
        val button74 = findViewById<Button>(R.id.button74)

        button1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button59.setOnClickListener {
            val intent = Intent(this, MainActivity12::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button66.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button67.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button68.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button69.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button70.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button71.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button72.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button73.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button74.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }


    }

}