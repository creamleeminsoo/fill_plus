package com.example.fill_plus.main
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fill_plus.R

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val button = findViewById<Button>(R.id.button113) // 버튼 객체 가져오기
        val button2 = findViewById<Button>(R.id.button105) // 버튼 객체 가져오기
        val button3 = findViewById<Button>(R.id.button25) // 버튼 객체 가져오기
        val button4 = findViewById<Button>(R.id.button24) // 버튼 객체 가져오기
        val button5 = findViewById<Button>(R.id.button26) // 버튼 객체 가져오기
        val button6= findViewById<Button>(R.id.button23) // 버튼 객체 가져오기
        val button7= findViewById<Button>(R.id.button27) // 버튼 객체 가져오기
        val button8= findViewById<Button>(R.id.button22) // 버튼 객체 가져오기
        val button9= findViewById<Button>(R.id.button28) // 버튼 객체 가져오기
        val button10= findViewById<Button>(R.id.button21) // 버튼 객체 가져오기
        val button11= findViewById<Button>(R.id.button29) // 버튼 객체 가져오기
        val button12= findViewById<Button>(R.id.button111) // 버튼 객체 가져오기


        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button2.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button3.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button4.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button5.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button6.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button7.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button8.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button9.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button10.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button11.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button12.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
    }
}