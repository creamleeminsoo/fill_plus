package com.example.fill_plus.login

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fill_plus.main.MainActivity2
import com.example.fill_plus.R
import com.example.fill_plus.signup.signupActivity1
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class loginActivity1 : AppCompatActivity(), View.OnClickListener {


    //firebase Auth
    lateinit var firebaseAuth: FirebaseAuth // 기존 코드는 private
    //google client
    lateinit var googleSignInClient: GoogleSignInClient // 기존 코드는 private

    //private const val TAG = "GoogleActivity"
    val RC_SIGN_IN = 99 // 기존 코드는 private
    private lateinit var auth: FirebaseAuth
    lateinit var user :FirebaseUser


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        auth = Firebase.auth


        var 이메일아이디 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.이메일아이디)
        var 비밀번호 = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.비밀번호)
        val 회원가입 = findViewById<Button>(R.id.회원가입버튼) // 버튼 객체 가져오기
        회원가입.setOnClickListener{
            val intent = Intent(this, signupActivity1::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }
        val 로그인 = findViewById<Button>(R.id.로그인) // 버튼 객체 가져오기
        로그인.setOnClickListener{
            signInWithEmailAndPassword(이메일아이디.text.toString().trim(), 비밀번호.text.toString().trim())
        }



        //btn_googleSignIn.setOnClickListener (this) // 구글 로그인 버튼
        val btn_googleSignIn = findViewById<com.google.android.gms.common.SignInButton>(R.id.btn_googleSignIn) // 버튼 객체 가져오기

        btn_googleSignIn.setOnClickListener {signIn()}

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


    }

    // onStart. 유저가 앱에 이미 구글 로그인을 했는지 확인
    public override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account!==null){ // 이미 로그인 되어있을시 바로 메인 액티비티로 이동
            toMainActivity(firebaseAuth.currentUser)
        }
    } //onStart End

    // onActivityResult
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("MainActivity6", "Google sign in failed", e)
            }
        }
    } // onActivityResult End

    // firebaseAuthWithGoogle
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d("MainActivity6", "firebaseAuthWithGoogle:" + acct.id!!)

        //Google SignInAccount 객체에서 ID 토큰을 가져와서 Firebase Auth로 교환하고 Firebase에 인증
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.w("MainActivity6", "firebaseAuthWithGoogle 성공", task.exception)
                    toMainActivity(firebaseAuth?.currentUser)
                } else {
                    Log.w("MainActivity6", "firebaseAuthWithGoogle 실패", task.exception)
                    //Snackbar.make(login_layout, "로그인에 실패하였습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
    }// firebaseAuthWithGoogle END


    // toMainActivity
    fun toMainActivity(user: FirebaseUser?) {
        if(user !=null) { // MainActivity 로 이동
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    } // toMainActivity End

    // signIn
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    // signIn End

    override fun onClick(p0: View?) {
    }


    fun signOut() { // 로그아웃
        // Firebase sign out
        firebaseAuth.signOut()

        // Google sign out
        googleSignInClient.signOut().addOnCompleteListener(this) {
            //updateUI(null)
        }
    }

    private fun revokeAccess() { //회원탈퇴
        // Firebase sign out
        firebaseAuth.signOut()
        googleSignInClient.revokeAccess().addOnCompleteListener(this) {

        }
    }
    // 로그인 함수
    fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // 로그인 성공
                    user = auth.currentUser
                    // 로그인한 사용자에 대한 추가 작업 수행 가능
                    // 예: 사용자 정보 가져오기, 화면 전환 등
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                } else {
                    // 로그인 실패
                    val exception = task.exception
                    // 예외 처리 및 오류 메시지 출력
                    exception?.message?.let {
                        Log.e(ContentValues.TAG, "로그인 실패: $it")
                    }
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
    }

}