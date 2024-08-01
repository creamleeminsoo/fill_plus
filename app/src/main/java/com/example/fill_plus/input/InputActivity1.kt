package com.example.fill_plus.input


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fill_plus.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InputActivity1 : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var saveButton: Button
    private lateinit var databaseRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var uidRef: DatabaseReference
    val currentUser = FirebaseAuth.getInstance().currentUser
    val uid = currentUser?.uid
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input1)


        val uid2 : String? = currentUser?.uid
        val uid: String = uid2?.toString() ?: ""
        // Firebase Realtime Database 초기화
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!
        editText = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.술)
        var age_editText = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.담배)
        var weight_kg_edittext = findViewById<com.google.android.material.textfield.TextInputEditText>(
            R.id.운동
        )
        var height_cm_edittext = findViewById<com.google.android.material.textfield.TextInputEditText>(
            R.id.햇빛
        )
        var gender_text:String = ""
        var maleButton = findViewById<Button>(R.id.귀_청력) // 버튼 객체 가져오기
        var femaleButton = findViewById<Button>(R.id.femaleButton) // 버튼 객체 가져오기
        var gender_view = findViewById<TextView>(R.id.gender_view)

        maleButton.setOnClickListener {
            gender_text = "male"
            gender_view.text = "male"

        }
        femaleButton.setOnClickListener {
            gender_text = "female"
            gender_view.text = "male"

        }
        saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val Nickname_text = editText.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val age_text = age_editText.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val weight_kg_text = weight_kg_edittext.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            val height_cm_text = height_cm_edittext.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            saveTextToDatabase(Nickname_text,age_text,height_cm_text,weight_kg_text,gender_text)
        }

    }


        fun saveTextToDatabase(text1: String,text2: String,text3: String,text4: String,text5: String) {

            // 파이어베이스 Realtime Database에 데이터 저장
            //databaseRef.child("text").setValue(text)
            uidRef.child("닉네임").setValue(text1)
            uidRef.child("나이(만)").setValue(text2)
            uidRef.child("신장(cm)").setValue(text3)
            uidRef.child("체중(kg)").setValue(text4)
            val intent = Intent(this, InputActivity2::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작

            //databaseRef.user
            //databaseRef.ref('test/').push({"name": "테스트", "location": "seoul"})
            //database.ref('test/').push({"name": "테스트2", "intro": "인삿말"})

            //databaseRef.child("name").setValue("John")

            //databaseRef.child("age").setValue(25)
            //usersRef.child("users").setValue("0kp1BvoHAuOOZWPr0TCYaLscvzI3")


    }
}
