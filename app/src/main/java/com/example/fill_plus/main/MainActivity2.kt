package com.example.fill_plus.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.fill_plus.R
import com.example.fill_plus.SearchActivity
import com.example.fill_plus.input.InputActivity1
import com.example.fill_plus.login.loginActivity1
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


class MainActivity2 : AppCompatActivity() {

    //firebase Auth
    lateinit var firebaseAuth: FirebaseAuth // 기존 코드는 private
    //google client
    lateinit var googleSignInClient: GoogleSignInClient // 기존 코드는 private
    //private const val TAG = "GoogleActivity"
    val RC_SIGN_IN = 99 // 기존 코드는 private

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //임시 버튼
        val button55 = findViewById<Button>(R.id.지성) // 버튼 객체 가져오기
        button55.setOnClickListener {
            val intent = Intent(this, InputActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        //
        //Google 로그인 옵션 구성. requestIdToken 및 Email 요청
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            //'R.string.default_web_client_id' 에는 본인의 클라이언트 아이디를 넣어주시면 됩니다.
            //저는 스트링을 따로 빼서 저렇게 사용했지만 스트링을 통째로 넣으셔도 됩니다.
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        //firebase auth 객체
        firebaseAuth = FirebaseAuth.getInstance()

        val signout = findViewById<Button>(R.id.signout) // 로그아웃 버튼
        // 액티비티 2의 인스턴스를 생성
        signout.setOnClickListener {
            signOut()
            val intent = Intent(this, loginActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
            //val intent = Intent(this, MainActivity6::class.java) // 인텐트 생성
            //startActivity(intent) // 다음 액티비티 시작
        }


        val button = findViewById<Button>(R.id.button17) // 버튼 객체 가져오기
        val button2 = findViewById<Button>(R.id.button18) // 버튼 객체 가져오기
        val button3 = findViewById<Button>(R.id.button8) // 버튼 객체 가져오기
        val button4 = findViewById<Button>(R.id.button20) // 버튼 객체 가져오기
        val button5 = findViewById<Button>(R.id.약관확인) // 버튼 객체 가져오기
        val button6 = findViewById<Button>(R.id.button19) // 버튼 객체 가져오기
        val button7 = findViewById<Button>(R.id.중성) // 버튼 객체 가져오기
        val button8 = findViewById<Button>(R.id.button13) // 버튼 객체 가져오기
        val button9 = findViewById<Button>(R.id.button13) // 버튼 객체 가져오기
        val button12 = findViewById<Button>(R.id.button13) // 버튼 객체 가져오기
        val button13 = findViewById<Button>(R.id.button10) // 버튼 객체 가져오기
        val button14 = findViewById<Button>(R.id.button11) // 버튼 객체 가져오기
        val button20 = findViewById<Button>(R.id.button14) // 버튼 객체 가져오기
        val imgbutton = findViewById<ImageButton>(R.id.imageButton2)

        imgbutton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작S
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
        button12.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button13.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        button14.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java) // 인텐트 생성// my페이지
            startActivity(intent) // 다음 액티비티 시작
        }
        button20.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }



    }
    fun signOut() { // 로그아웃
        // Firebase sign out
        firebaseAuth.signOut()

        // Google sign out
        googleSignInClient.signOut().addOnCompleteListener(this) {
            //updateUI(null)
        }}

}