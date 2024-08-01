package com.example.fill_plus.signup


import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fill_plus.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class signupActivity1 : AppCompatActivity() {
    private lateinit var databaseRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var uidRef: DatabaseReference
    var currentUser = FirebaseAuth.getInstance().currentUser
    var uid = currentUser?.uid
    private lateinit var 아이디에딧텍스트: TextInputEditText
    private lateinit var pw에딧텍스트: TextInputEditText
    private lateinit var 닉네임에딧텍스트: TextInputEditText
    private lateinit var 신장에딧텍스트: TextInputEditText
    private lateinit var 체중에딧텍스트: TextInputEditText
    private lateinit var 남성체크버튼: Button
    private lateinit var 여성체크버튼: Button

    private lateinit var 성별: String
    private lateinit var 아이디확인: TextView
    private lateinit var 비밀번호확인: TextView
    private lateinit var 닉네임확인: TextView
    private lateinit var auth: FirebaseAuth
    lateinit var user :FirebaseUser



    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // 필요 없는 메서드이므로 무시합니다.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val inputId = 아이디에딧텍스트.text.toString()
            val isIdAvailable = checkIdAvailability(inputId)
            아이디확인.text = if (isIdAvailable) "사용 가능한 ID입니다!" else "사용 불가능한 ID입니다"
        }

        override fun afterTextChanged(s: Editable?) {
            // 필요 없는 메서드이므로 무시합니다.
        }
    }
    private val passwordWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // 필요 없는 메서드이므로 무시합니다.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val inputPassword = pw에딧텍스트.text.toString()
            val isPasswordAvailable = checkPasswordAvailability(inputPassword)
            비밀번호확인.text = if (isPasswordAvailable) "사용 가능한 비밀번호입니다!" else "사용 불가능한 비밀번호입니다"
        }

        override fun afterTextChanged(s: Editable?) {
            // 필요 없는 메서드이므로 무시합니다.
        }
    }
    private val nicknameWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // 필요 없는 메서드이므로 무시합니다.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val inputNickname = 닉네임에딧텍스트.text.toString()
            val isNicknameAvailable = checkNicknameAvailability(inputNickname)
            닉네임확인.text = if (isNicknameAvailable) "사용 가능한 닉네임입니다!" else "사용 불가능한 닉네임입니다"
        }

        override fun afterTextChanged(s: Editable?) {
            // 필요 없는 메서드이므로 무시합니다.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlog1)
        auth = Firebase.auth
        // Firebase Realtime Database 초기화
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")


        여성체크버튼 = findViewById<Button>(R.id.건성)
        남성체크버튼 = findViewById<Button>(R.id.중성)
        val 다음 = findViewById<Button>(R.id.지성)
        신장에딧텍스트 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.신장)
        체중에딧텍스트 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.체중)

        아이디에딧텍스트 = findViewById(R.id.아이디)
        pw에딧텍스트 = findViewById(R.id.비밀번호)
        닉네임에딧텍스트 = findViewById(R.id.닉네임)
        아이디확인 = findViewById(R.id.아이디확인)
        비밀번호확인 = findViewById(R.id.비밀번호확인)
        닉네임확인 = findViewById(R.id.닉네임확인)


        pw에딧텍스트.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        여성체크버튼.setOnClickListener {
            if (여성체크버튼.text == "") {
                여성체크버튼.text = "V"
            } else {
                여성체크버튼.text = ""
            }
        }
        남성체크버튼.setOnClickListener {
            if (남성체크버튼.text == "") {
                남성체크버튼.text = "V"
            } else {
                남성체크버튼.text = ""
            }
        }
        다음.setOnClickListener {
            signUpWithEmailAndPassword(아이디에딧텍스트.text.toString().trim(), pw에딧텍스트.text.toString().trim())
            //Toast.makeText(this, uid.toString(), Toast.LENGTH_SHORT).show()
            //var intent = Intent(this, signupActivity2::class.java)
            //intent.putExtra("user", user)
            //startActivity(intent)
        }

        아이디에딧텍스트.addTextChangedListener(textWatcher)
        pw에딧텍스트.addTextChangedListener(passwordWatcher)
        닉네임에딧텍스트.addTextChangedListener(nicknameWatcher)

    }

    private fun checkIdAvailability(inputId: String): Boolean {
        // 아이디 가용성을 확인하는 로직을 여기에 작성.

        return inputId.isNotEmpty()
    }

    private fun checkPasswordAvailability(inputPassword: String): Boolean {
        // 비밀번호 가용성을 확인하는 로직을 여기에 작성.


        return inputPassword.length >= 8
    }

    private fun checkNicknameAvailability(inputNickname: String): Boolean {
        // 닉네임 가용성을 확인하는 로직을 여기에 작성.
        val nicknameLength = inputNickname.length

        return nicknameLength in 2..21
    }



    //회원가입함수
    private fun signUpWithEmailAndPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // 회원가입 성공
                    user = auth.currentUser
                    signInWithEmailAndPassword(email, password) // 로그인 수행
                    // 회원가입한 사용자에 대한 추가 작업 수행 가능
                    // 예: 사용자에게 환영 이메일 보내기 등
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                } else {
                    // 회원가입 실패
                    val exception = task.exception
                    // 예외 처리 및 오류 메시지 출력
                    exception?.message?.let {
                        Log.e(ContentValues.TAG, "회원가입 실패: $it")
                    }
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // 로그인 함수
    fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // 로그인 성공
                    user = auth.currentUser
                    //currentUser = Firebase.auth.currentUser
                    uid = user.uid
                    usersRef = databaseRef.child("users")
                    uidRef = usersRef.child(uid.toString())//!!!
                    if (남성체크버튼.text == "V") { 성별 = "남성"}
                    if (여성체크버튼.text == "V") { 성별 = "여성"}
                    uidRef.child("닉네임").setValue(닉네임에딧텍스트.text.toString().trim())
                    uidRef.child("신장").setValue(닉네임에딧텍스트.text.toString().trim())
                    uidRef.child("체중").setValue(닉네임에딧텍스트.text.toString().trim())
                    uidRef.child("성별").setValue(성별)
                    var intent = Intent(this, signupActivity2::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)



                    // 로그인한 사용자에 대한 추가 작업 수행 가능
                    // 예: 사용자 정보 가져오기, 화면 전환 등
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                } else {
                    // 로그인 실패
                    val exception = task.exception
                    // 예외 처리 및 오류 메시지 출력
                    exception?.message?.let {
                        Log.e(TAG, "로그인 실패: $it")
                    }
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
    }
}










