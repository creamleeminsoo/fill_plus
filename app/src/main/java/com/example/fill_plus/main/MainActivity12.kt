package com.example.fill_plus.main



import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.TextView
import com.example.fill_plus.R
import com.example.fill_plus.login.loginActivity1
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.*


class MainActivity12 : AppCompatActivity() {
    private var popupWindow: PopupWindow? = null

    @SuppressLint("MissingInflatedId", "ServiceCast")
    //firebase Auth
    lateinit var firebaseAuth: FirebaseAuth // 기존 코드는 private
    //google client
    lateinit var googleSignInClient: GoogleSignInClient // 기존 코드는 private
    //private const val TAG = "GoogleActivity"
    val RC_SIGN_IN = 99 // 기존 코드는 private
    private lateinit var editText: EditText
    private lateinit var saveButton: Button
    private lateinit var databaseRef: DatabaseReference
    private lateinit var usersRef: DatabaseReference
    private lateinit var uidRef: DatabaseReference
    val currentUser = FirebaseAuth.getInstance().currentUser
    var uid2 : String? = currentUser?.uid
    var uid: String = uid2?.toString() ?: ""
    val database = FirebaseDatabase.getInstance()
    //val reference = database.reference.child("users").child(uid).child("닉네임")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmy2)

        val button52 = findViewById<Button>(R.id.button52)

        button52.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent) // 다음 액티비티 시작
        }



        val uid2 : String? = currentUser?.uid
        val uid: String = uid2?.toString() ?: ""
        // Firebase Realtime Database 초기화
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!

        var nickname_editText = findViewById<com.google.android.material.textfield.TextInputEditText>(
            R.id.아이디
        )
        // "b"의 값을 가져와 변수 d로 선언
        database.reference.child("users").child(uid).child("닉네임").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val d = dataSnapshot.getValue(String::class.java)
                    nickname_editText.hint = d
                    // d 변수로 가져온 값 사용
                    // 예: Log.d("TAG", d)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // 에러 처리
            }
        })


        var nickname_saveButton = findViewById<Button>(R.id.nickname_saveButton)
        nickname_saveButton.setOnClickListener { showPopupWindow(R.layout.popup_layout) }

        var popupButton55 = findViewById<Button>(R.id.button55)
        popupButton55.setOnClickListener {
            showPopupWindow2(R.layout.popup_layout2)
        }


            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(this, gso)

            //firebase auth 객체
            firebaseAuth = FirebaseAuth.getInstance()

            val signout = findViewById<Button>(R.id.signout) // 로그아웃 버튼
            signout.setOnClickListener {
                signOut()
                val intent = Intent(this, loginActivity1::class.java) // 인텐트 생성
                startActivity(intent) // 다음 액티비티 시작
            }


    }


    private fun showPopupWindow(layoutId: Int) {
        val inflater: LayoutInflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(layoutId, null)
        fun Int.dpToPx(): Int {
            return (this * Resources.getSystem().displayMetrics.density).toInt()
        }

        val popupWindow = PopupWindow(
            popupView,
            360.dpToPx(),  // 가로 사이즈
            500.dpToPx()   // 세로 사이즈
        )

        popupWindow.isFocusable = true

        // 작은 창을 원하는 위치에 표시

        var 변경완료 : Button = popupView.findViewById(R.id.변경완료)
        변경완료.setOnClickListener{
            val 닉네임: TextView = popupView.findViewById(R.id.아이디)
            val nickname_text = 닉네임.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            nickname_saveTextToDatabase(nickname_text)
            popupWindow.dismiss()
            val intent = Intent(this, MainActivity12::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작

        }
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        if (layoutId == R.layout.popup_layout) {
            val textView4: TextView = popupView.findViewById(R.id.textView4)
            val textInputEditText: TextInputEditText =
                popupView.findViewById(R.id.아이디)
            //var 변경완료 : Button = popupView.findViewById(R.id.변경완료)
            //val nickname_text = textView4.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            //nickname_saveTextToDatabase(nickname_text)




            textInputEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // 이전 텍스트 변경 전
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // 텍스트 변경 중
                }

                override fun afterTextChanged(s: Editable?) {
                    // 텍스트 변경 후
                    val enteredText = s?.toString()
                    if (enteredText != null && enteredText.length >= 2) {
                        textView4.text = "사용가능한 닉네임입니다!"
                    } else {
                        textView4.text = "사용불가능한 닉네임입니다"
                    }
                }
            })
        } else if (layoutId == R.layout.popup_layout2) {
            val textView5: TextView = popupView.findViewById(R.id.textView5)
            val textInputEditText2: TextInputEditText =
                popupView.findViewById(R.id.비밀번호)

            textInputEditText2.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // 이전 텍스트 변경 전
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // 텍스트 변경 중
                }

                override fun afterTextChanged(s: Editable?) {
                    // 텍스트 변경 후
                    val enteredText = s?.toString()
                    if (enteredText != null && enteredText.length >= 8) {
                        textView5.text = "사용가능한 비밀번호입니다!"
                    } else {
                        textView5.text = "사용불가능한 비밀번호입니다"
                    }
                }
            })

            textInputEditText2.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun showPopupWindow2(layoutId: Int) {
        val inflater: LayoutInflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(layoutId, null)
        fun Int.dpToPx(): Int {
            return (this * Resources.getSystem().displayMetrics.density).toInt()
        }

        val popupWindow = PopupWindow(
            popupView,
            360.dpToPx(),  // 가로 사이즈
            500.dpToPx()   // 세로 사이즈
        )

        popupWindow.isFocusable = true

        // 작은 창을 원하는 위치에 표시
        var button61 : Button = popupView.findViewById(R.id.button61)
        button61.setOnClickListener{
            val 닉네임: TextView = popupView.findViewById(R.id.비밀번호)
            val nickname_text = 닉네임.text.toString().trim()// 에딧텍스트에 입력한 텍스트 변수화
            //nickname_saveTextToDatabase(nickname_text) 비밀번호 저장기능 미구현
            popupWindow.dismiss()
            val intent = Intent(this, MainActivity12::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작

        }
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        if (layoutId == R.layout.popup_layout2) {
            val textView5: TextView = popupView.findViewById(R.id.textView5)
            val textInputEditText2: TextInputEditText =
                popupView.findViewById(R.id.비밀번호)

            textInputEditText2.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // 이전 텍스트 변경 전
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // 텍스트 변경 중
                }

                override fun afterTextChanged(s: Editable?) {
                    // 텍스트 변경 후
                    val enteredText = s?.toString()
                    if (enteredText != null && enteredText.length >= 8) {
                        textView5.text = "사용가능한 비밀번호입니다!"
                    } else {
                        textView5.text = "사용불가능한 비밀번호입니다"
                    }
                }
            })

            textInputEditText2.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
    fun nickname_saveTextToDatabase(text1: String) {
        uidRef.child("닉네임").setValue(text1)
    }

    fun signOut() { // 로그아웃
        // Firebase sign out
        firebaseAuth.signOut()

        // Google sign out
        googleSignInClient.signOut().addOnCompleteListener(this) {
            //updateUI(null)
        }
    }

}
