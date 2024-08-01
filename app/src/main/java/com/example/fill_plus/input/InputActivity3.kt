package com.example.fill_plus.input

import android.os.Bundle
import android.widget.Button
import com.example.fill_plus.R
import com.example.fill_plus.databaseRef
import com.example.fill_plus.saveButton
import com.example.fill_plus.uidRef
import com.example.fill_plus.usersRef
import com.example.fill_plus.관심분야

/*









package com.example.fill_plus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase




private lateinit var saveButton: Button
private lateinit var databaseRef: DatabaseReference
private lateinit var usersRef: DatabaseReference
private lateinit var uidRef: DatabaseReference
private lateinit var 관심분야: DatabaseReference
private var currentUser = FirebaseAuth.getInstance().currentUser
private var uid = currentUser?.uid



class InputActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input4)



        val uid2: String? = currentUser?.uid
        val uid: String = uid2?.toString() ?: ""
        // Firebase Realtime Database 초기화
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!
        관심분야 = uidRef.child("관심분야")//!!!



        var 통증완화Button = findViewById<Button>(R.id.통증완화) // 버튼 객체 가져오기
        var 디톡스Button = findViewById<Button>(R.id.디톡스) // 버튼 객체 가져오기
        var 뼈_관절Button = findViewById<Button>(R.id.뼈_관절) // 버튼 객체 가져오기
        var 노화방지_항산화Button = findViewById<Button>(R.id.노화방지_항산화) // 버튼 객체 가져오기
        var 뇌_인지력Button = findViewById<Button>(R.id.뇌_인지력) // 버튼 객체 가져오기
        var 어린이건강 = findViewById<Button>(R.id.어린이건강) // 버튼 객체 가져오기
        var 남성건강Button = findViewById<Button>(R.id.남성건강) // 버튼 객체 가져오기
        var 여성건강Button = findViewById<Button>(R.id.여성건강) // 버튼 객체 가져오기
        var 감기Button = findViewById<Button>(R.id.감기) // 버튼 객체 가져오기
        var 비타민Button = findViewById<Button>(R.id.비타민) // 버튼 객체 가져오기
        var 통증완화_text:String = "false"
        var 디톡스_text:String = "false"
        var 뼈_관절_text:String = "false"
        var 노화방지_항산화_text:String = "false"
        var 뇌_인지력_text:String = "false"
        var 어린이건강_text:String = "false"
        var 남성건강_text:String = "false"
        var 여성건강_text:String = "false"
        var 감기_text:String = "false"
        var 비타민_text:String = "false"


        통증완화Button.setOnClickListener { 통증완화_text = "true" }
        디톡스Button.setOnClickListener { 디톡스_text = "true" }
        뼈_관절Button.setOnClickListener { 뼈_관절_text = "true" }
        노화방지_항산화Button.setOnClickListener { 노화방지_항산화_text = "true" }
        뇌_인지력Button.setOnClickListener { 뇌_인지력_text = "true" }
        어린이건강.setOnClickListener { 어린이건강_text = "true" }
        남성건강Button.setOnClickListener { 남성건강_text = "true" }
        여성건강Button.setOnClickListener { 여성건강_text = "true" }
        감기Button.setOnClickListener { 감기_text = "true" }
        비타민Button.setOnClickListener { 비타민_text = "true" }

        saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {

            saveTextToDatabase(통증완화_text, 디톡스_text, 뼈_관절_text, 노화방지_항산화_text, 뇌_인지력_text,어린이건강_text, 남성건강_text, 여성건강_text, 감기_text, 비타민_text)
            val intent = Intent(this, MainActivity2::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
    }
    fun saveTextToDatabase(text1: String,text2: String,text3: String,text4: String,text5: String,text6: String,text7: String,text8: String,text9: String,text10: String) {

        // 파이어베이스 Realtime Database에 데이터 저장
        //databaseRef.child("text").setValue(text)
        관심분야.child("통증완화").setValue(text1)
        관심분야.child("디톡스").setValue(text2)
        관심분야.child("뼈_관절").setValue(text3)
        관심분야.child("노화방지_항산화").setValue(text4)
        관심분야.child("뇌_인지력").setValue(text5)
        관심분야.child("어린이건강").setValue(text6)
        관심분야.child("남성건강").setValue(text7)
        관심분야.child("여성건강").setValue(text8)
        관심분야.child("감기").setValue(text9)
        관심분야.child("비타민").setValue(text10)


    }



}
*/class InputActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input3)

        // Firebase Realtime Database 초기화
        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid.toString()
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!
        관심분야 = uidRef.child("관심분야")//!!!



        var 귀_청력Button = findViewById<Button>(R.id.귀_청력) // 버튼 객체 가져오기
        var 대장Button = findViewById<Button>(R.id.대장) // 버튼 객체 가져오기
        var 모발_피부Button = findViewById<Button>(R.id.모발_피부) // 버튼 객체 가져오기
        var 에너지Button = findViewById<Button>(R.id.에너지) // 버튼 객체 가져오기
        var 심혈관계Button = findViewById<Button>(R.id.심혈관계) // 버튼 객체 가져오기
        var 면역기계Button = findViewById<Button>(R.id.면역기계) // 버튼 객체 가져오기
        var 호흡기계Button = findViewById<Button>(R.id.호흡기계) // 버튼 객체 가져오기
        var 계절성알레르기Button = findViewById<Button>(R.id.계절성알레르기) // 버튼 객체 가져오기
        var 체중관리Button = findViewById<Button>(R.id.체중관리) // 버튼 객체 가져오기
        var 수면Button = findViewById<Button>(R.id.수면) // 버튼 객체 가져오기
        var 귀_청력_text:String = "false"
        var 대장_text:String = "false"
        var 모발_피부_text:String = "false"
        var 에너지_text:String = "false"
        var 심혈관계_text:String = "false"
        var 면역기계_text:String = "false"
        var 호흡기계_text:String = "false"
        var 계절성알레르기_text:String = "false"
        var 체중관리_text:String = "false"
        var 수면_text:String = "false"


        귀_청력Button.setOnClickListener { 귀_청력_text = "true" }
        대장Button.setOnClickListener { 대장_text = "true" }
        모발_피부Button.setOnClickListener { 모발_피부_text = "true" }
        에너지Button.setOnClickListener { 에너지_text = "true" }
        심혈관계Button.setOnClickListener { 심혈관계_text = "true" }
        면역기계Button.setOnClickListener { 면역기계_text = "true" }
        호흡기계Button.setOnClickListener { 호흡기계_text = "true" }
        계절성알레르기Button.setOnClickListener { 계절성알레르기_text = "true" }
        체중관리Button.setOnClickListener { 체중관리_text = "true" }
        수면Button.setOnClickListener { 수면_text = "true" }

        saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {

            saveTextToDatabase(귀_청력_text, 대장_text, 모발_피부_text, 에너지_text, 심혈관계_text,면역기계_text, 호흡기계_text, 계절성알레르기_text, 체중관리_text, 수면_text)
            val intent = Intent(this, InputActivity4::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
    }
        fun saveTextToDatabase(text1: String,text2: String,text3: String,text4: String,text5: String,text6: String,text7: String,text8: String,text9: String,text10: String) {

            // 파이어베이스 Realtime Database에 데이터 저장
            //databaseRef.child("text").setValue(text)
            관심분야.child("귀_청력").setValue(text1)
            관심분야.child("대장").setValue(text2)
            관심분야.child("모발_피부").setValue(text3)
            관심분야.child("에너지").setValue(text4)
            관심분야.child("심혈관계").setValue(text5)
            관심분야.child("면역기계").setValue(text6)
            관심분야.child("호흡기계").setValue(text7)
            관심분야.child("계절성알레르기").setValue(text8)
            관심분야.child("체중관리").setValue(text9)
            관심분야.child("수면").setValue(text10)


    }
}