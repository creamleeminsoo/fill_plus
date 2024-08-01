package com.example.fill_plus.signup

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import com.example.fill_plus.R
import com.example.fill_plus.databaseRef
import com.example.fill_plus.uidRef
import com.example.fill_plus.usersRef

class signupActivity2 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlog2)

        val 중성 = findViewById<Button>(R.id.중성) // 버튼 객체 가져오기
        val 지성 = findViewById<Button>(R.id.지성) // 버튼 객체 가져오기
        val 건성 = findViewById<Button>(R.id.건성)
        val 다음 = findViewById<Button>(R.id.다음)
        val 복합성 = findViewById<Button>(R.id.복합성)
        var 나이 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.나이)
        var 술 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.술)
        var 담배 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.담배)
        var 운동 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.운동)
        var 햇빛 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.햇빛)
        var 질병 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.질병)


        건성.setOnClickListener {
            if (건성.text == "") {
                건성.text = "V"
            } else {
                건성.text = ""
            }
        }
        중성.setOnClickListener {
            if (중성.text == "") {
                중성.text = "V"
            } else {
                중성.text = ""
            }
        }
        지성.setOnClickListener {
            if (지성.text == "") {
                지성.text = "V"
            } else {
                지성.text = ""
            }
        }
        복합성.setOnClickListener {
            if (복합성.text == "") {
                복합성.text = "V"
            } else {
                복합성.text = ""
            }
        }



        //val user = intent.getSerializableExtra("user") as  FirebaseUser
        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid.toString()
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!

        다음.setOnClickListener {
            val 술_text = 술.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 담배_text = 담배.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 운동_text = 운동.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 햇빛_text = 햇빛.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 질병_text = 질병.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 나이_text = 나이.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화


            var 피부 = ""
            if (지성.text == "V") { 피부 = "지성"}
            if (중성.text == "V") { 피부 = "중성"}
            if (건성.text == "V") { 피부 = "건성"}
            if (복합성.text == "V") { 피부 = "복합성"}
            saveTextToDatabase(술_text,담배_text,운동_text,햇빛_text,질병_text,피부,나이_text)
            val intent = Intent(this, signupActivity3::class.java) // 인텐트 생성
            //intent.putExtra("user", user)
            startActivity(intent) // 다음 액티비티 시작
        }



    }

    fun saveTextToDatabase(text1: String,text2: String,text3: String,text4: String,text5: String,text6: String,text7: String) {

        // 파이어베이스 Realtime Database에 데이터 저장
        uidRef.child("술").setValue(text1)
        uidRef.child("담배").setValue(text2)
        uidRef.child("운동").setValue(text3)
        uidRef.child("햇빛").setValue(text4)
        uidRef.child("질병").setValue(text5)
        uidRef.child("피부").setValue(text6)
        uidRef.child("나이").setValue(text7)




    }

}