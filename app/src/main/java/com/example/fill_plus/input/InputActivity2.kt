package com.example.fill_plus.input


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fill_plus.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class InputActivity2 : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var saveButton: Button
    private lateinit var databaseRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var uidRef: DatabaseReference
    //val currentUser = FirebaseAuth.getInstance().currentUser
    //val uid = currentUser?.uid
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input2)

        // Firebase Realtime Database 초기화
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(Firebase.auth.currentUser.uid)//!!!
        var 술 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.술)
        var 담배 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.담배)
        var 운동 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.운동)
        var 햇빛 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.햇빛)

        var skin_text:String = ""
        var 건성Button = findViewById<Button>(R.id.귀_청력) // 버튼 객체 가져오기
        var 중성Button = findViewById<Button>(R.id.중성) // 버튼 객체 가져오기
        var 지성Button = findViewById<Button>(R.id.지성) // 버튼 객체 가져오기
        var 복합성Button = findViewById<Button>(R.id.복합성) // 버튼 객체 가져오기
        var skin_view = findViewById<TextView>(R.id.skin_view)

        건성Button.setOnClickListener {
            skin_text = "건성"
            skin_view.text = "건성"
        }
        중성Button.setOnClickListener {
            skin_text = "중성"
            skin_view.text = "중성"
        }
        지성Button.setOnClickListener {
            skin_text = "지성"
            skin_view.text = "지성"
        }
        복합성Button.setOnClickListener {
            skin_text = "복합성"
            skin_view.text = "복합성"
        }

        saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val 술_text = 술.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 담배_text = 담배.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 운동_text = 운동.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val 햇빛_text = 햇빛.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            saveTextToDatabase(술_text,담배_text,운동_text,햇빛_text,skin_text)
            val intent = Intent(this, InputActivity3::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }

    }


    fun saveTextToDatabase(text1: String,text2: String,text3: String,text4: String,text5: String) {

        // 파이어베이스 Realtime Database에 데이터 저장
        //databaseRef.child("text").setValue(text)
        uidRef.child("술").setValue(text1)
        uidRef.child("담배").setValue(text2)
        uidRef.child("운동").setValue(text3)
        uidRef.child("햇빛").setValue(text4)
        uidRef.child("피부").setValue(text5)



    }

}
