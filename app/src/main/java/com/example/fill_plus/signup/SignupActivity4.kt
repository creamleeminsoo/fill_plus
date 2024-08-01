package com.example.fill_plus.signup

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import com.example.fill_plus.R
import com.example.fill_plus.databaseRef
import com.example.fill_plus.uidRef
import com.example.fill_plus.usersRef
import com.example.fill_plus.관심분야

class signupActivity4 : AppCompatActivity() {

    //private val buttonStates = mutableMapOf<Int, Boolean>()

    //@SuppressLint("DiscouragedApi")
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlog4)

        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid.toString()
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!
        관심분야 = uidRef.child("관심분야")//!!!

        var 통증완화 = findViewById<Button>(R.id.통증완화)
        var 디톡스 = findViewById<Button>(R.id.디톡스) // 버튼 객체 가져오기
        var 뼈_관절 = findViewById<Button>(R.id.뼈_관절) // 버튼 객체 가져오기
        var 노화방지_항산화 = findViewById<Button>(R.id.노화방지_항산화) // 버튼 객체 가져오기
        var 뇌_인지력 = findViewById<Button>(R.id.뇌_인지력) // 버튼 객체 가져오기
        var 어린이건강 = findViewById<Button>(R.id.어린이건강) // 버튼 객체 가져오기
        var 남성건강 = findViewById<Button>(R.id.남성건강) // 버튼 객체 가져오기
        var 여성건강 = findViewById<Button>(R.id.여성건강) // 버튼 객체 가져오기
        var 감기 = findViewById<Button>(R.id.감기) // 버튼 객체 가져오기
        var 비타민 = findViewById<Button>(R.id.비타민) // 버튼 객체 가져오기
        val 다음 = findViewById<Button>(R.id.다음)

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

        통증완화.setOnClickListener {
            if (통증완화_text == "false") {
                통증완화_text = "true"
                통증완화.text = "V"
                통증완화.setTextColor(Color.parseColor("#82FFFF"))
                통증완화.textSize = 60f
            } else {
                통증완화_text = "false"
                통증완화.text = ""
                통증완화.setTextColor(Color.BLACK)
                통증완화.textSize = 12f
            }
        }
        디톡스.setOnClickListener {
            if (디톡스_text == "false") {
                디톡스_text = "true"
                디톡스.text = "V"
                디톡스.setTextColor(Color.parseColor("#82FFFF"))
                디톡스.textSize = 60f
            } else {
                디톡스_text = "false"
                디톡스.text = ""
                디톡스.setTextColor(Color.BLACK)
                디톡스.textSize = 12f
            }
        }
        뼈_관절.setOnClickListener {
            if (뼈_관절_text == "false") {
                뼈_관절_text = "true"
                뼈_관절.text = "V"
                뼈_관절.setTextColor(Color.parseColor("#82FFFF"))
                뼈_관절.textSize = 60f
            } else {
                뼈_관절_text = "false"
                뼈_관절.text = ""
                뼈_관절.setTextColor(Color.BLACK)
                뼈_관절.textSize = 12f
            }
        }
        노화방지_항산화.setOnClickListener {
            if (노화방지_항산화_text == "false") {
                노화방지_항산화_text = "true"
                노화방지_항산화.text = "V"
                노화방지_항산화.setTextColor(Color.parseColor("#82FFFF"))
                노화방지_항산화.textSize = 60f
            } else {
                노화방지_항산화_text = "false"
                노화방지_항산화.text = ""
                노화방지_항산화.setTextColor(Color.BLACK)
                노화방지_항산화.textSize = 12f
            }
        }
        뇌_인지력.setOnClickListener {
            if (뇌_인지력_text == "false") {
                뇌_인지력_text = "true"
                뇌_인지력.text = "V"
                뇌_인지력.setTextColor(Color.parseColor("#82FFFF"))
                뇌_인지력.textSize = 60f
            } else {
                뇌_인지력_text = "false"
                뇌_인지력.text = ""
                뇌_인지력.setTextColor(Color.BLACK)
                뇌_인지력.textSize = 12f
            }
        }
        어린이건강.setOnClickListener {
            if (어린이건강_text == "false") {
                어린이건강_text = "true"
                어린이건강.text = "V"
                어린이건강.setTextColor(Color.parseColor("#82FFFF"))
                어린이건강.textSize = 60f
            } else {
                어린이건강_text = "false"
                어린이건강.text = ""
                어린이건강.setTextColor(Color.BLACK)
                어린이건강.textSize = 12f
            }
        }
        남성건강.setOnClickListener {
            if (남성건강_text == "false") {
                남성건강_text = "true"
                남성건강.text = "V"
                남성건강.setTextColor(Color.parseColor("#82FFFF"))
                남성건강.textSize = 60f
            } else {
                남성건강_text = "false"
                남성건강.text = ""
                남성건강.setTextColor(Color.BLACK)
                남성건강.textSize = 12f
            }
        }
        여성건강.setOnClickListener {
            if (여성건강_text == "false") {
                여성건강_text = "true"
                여성건강.text = "V"
                여성건강.setTextColor(Color.parseColor("#82FFFF"))
                여성건강.textSize = 60f
            } else {
                여성건강_text = "false"
                여성건강.text = ""
                여성건강.setTextColor(Color.BLACK)
                여성건강.textSize = 12f
            }
        }
        감기.setOnClickListener {
            if (감기_text == "false") {
                감기_text = "true"
                감기.text = "V"
                감기.setTextColor(Color.parseColor("#82FFFF"))
                감기.textSize = 60f
            } else {
                감기_text = "false"
                감기.text = ""
                감기.setTextColor(Color.BLACK)
                감기.textSize = 12f
            }
        }
        비타민.setOnClickListener {
            if (비타민_text == "false") {
                비타민_text = "true"
                비타민.text = "V"
                비타민.setTextColor(Color.parseColor("#82FFFF"))
                비타민.textSize = 60f
            } else {
                비타민_text = "false"
                비타민.text = ""
                비타민.setTextColor(Color.BLACK)
                비타민.textSize = 12f
            }
        }
        다음.setOnClickListener {
            saveTextToDatabase(통증완화_text, 디톡스_text, 뼈_관절_text, 노화방지_항산화_text, 뇌_인지력_text,어린이건강_text, 남성건강_text, 여성건강_text, 감기_text, 비타민_text)
            val intent = Intent(this, signupActivity5::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }

        /*
        for (i in 41..50) {
            buttonStates[i] = false
        }

        for (i in 41..50) {
            val buttonId = resources.getIdentifier("button$i", "id", packageName)
            val button = findViewById<Button>(buttonId)

            button.setOnClickListener {
                val currentState = buttonStates[i] ?: false
                if (currentState) {
                    button.text = ""
                    button.setTextColor(Color.BLACK)
                    button.textSize = 12f
                } else {
                    button.text = "V"
                    button.setTextColor(Color.parseColor("#82FFFF"))
                    button.textSize = 60f
                }

                // 버튼 클릭 상태 변경
                buttonStates[i] = !currentState
                val button51 = findViewById<Button>(R.id.button51)
                button51.setOnClickListener {
                    val intent = Intent(this, signupActivity5::class.java)
                    startActivity(intent)
                }
            }
        }*/
    }
    fun saveTextToDatabase(text1: String,text2: String,text3: String,text4: String,text5: String,text6: String,text7: String,text8: String,text9: String,text10: String) {
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