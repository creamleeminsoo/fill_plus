package com.example.fill_plus.signup

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import com.example.fill_plus.R
import com.example.fill_plus.databaseRef
import com.example.fill_plus.uidRef
import com.example.fill_plus.usersRef
import com.example.fill_plus.관심분야

class signupActivity3 : AppCompatActivity() {

    private val buttonStates = mutableMapOf<Int, Boolean>()

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainlog3)


        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid.toString()
        databaseRef = FirebaseDatabase.getInstance().reference
        usersRef = databaseRef.child("users")
        uidRef = usersRef.child(uid)//!!!
        관심분야 = uidRef.child("관심분야")//!!!

        var 귀_청력 = findViewById<Button>(R.id.귀_청력) // 버튼 객체 가져오기
        var 대장 = findViewById<Button>(R.id.대장) // 버튼 객체 가져오기
        var 모발_피부 = findViewById<Button>(R.id.모발_피부) // 버튼 객체 가져오기
        var 에너지 = findViewById<Button>(R.id.에너지) // 버튼 객체 가져오기
        var 심혈관계 = findViewById<Button>(R.id.심혈관계) // 버튼 객체 가져오기
        var 면역기계 = findViewById<Button>(R.id.면역기계) // 버튼 객체 가져오기
        var 호흡기계 = findViewById<Button>(R.id.호흡기계) // 버튼 객체 가져오기
        var 계절성알레르기 = findViewById<Button>(R.id.계절성알레르기) // 버튼 객체 가져오기
        var 체중관리 = findViewById<Button>(R.id.체중관리) // 버튼 객체 가져오기
        var 수면 = findViewById<Button>(R.id.수면) // 버튼 객체 가져오기
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
        /*
                            button.text = ""
                    button.setTextColor(Color.BLACK)
                    button.textSize = 12f
                } else {
                    button.text = "V"
                    button.setTextColor(Color.parseColor("#82FFFF"))
                    button.textSize = 60f
                }
         */
        귀_청력.setOnClickListener {
            if (귀_청력_text == "false") {
                귀_청력_text = "true"
                귀_청력.text = "V"
                귀_청력.setTextColor(Color.parseColor("#82FFFF"))
                귀_청력.textSize = 60f
            } else {
                귀_청력_text = "false"
                귀_청력.text = ""
                귀_청력.setTextColor(Color.BLACK)
                귀_청력.textSize = 12f
            }

        }
        대장.setOnClickListener {
            if (대장_text == "false") {
                대장_text = "true"
                대장.text = "V"
                대장.setTextColor(Color.parseColor("#82FFFF"))
                대장.textSize = 60f
            } else {
                대장_text = "false"
                대장.text = ""
                대장.setTextColor(Color.BLACK)
                대장.textSize = 12f
            }
        }
        모발_피부.setOnClickListener {
            if (모발_피부_text == "false") {
                모발_피부_text = "true"
                모발_피부.text = "V"
                모발_피부.setTextColor(Color.parseColor("#82FFFF"))
                모발_피부.textSize = 60f
            } else {
                모발_피부_text = "false"
                모발_피부.text = ""
                모발_피부.setTextColor(Color.BLACK)
                모발_피부.textSize = 12f
            }

        }
        에너지.setOnClickListener {
            if (에너지_text == "false") {
                에너지_text = "true"
                에너지.text = "V"
                에너지.setTextColor(Color.parseColor("#82FFFF"))
                에너지.textSize = 60f
            } else {
                에너지_text = "false"
                에너지.text = ""
                에너지.setTextColor(Color.BLACK)
                에너지.textSize = 12f
            }
        }
        심혈관계.setOnClickListener {
            if (심혈관계_text == "false") {
                심혈관계_text = "true"
                심혈관계.text = "V"
                심혈관계.setTextColor(Color.parseColor("#82FFFF"))
                심혈관계.textSize = 60f
            } else {
                심혈관계_text = "false"
                심혈관계.text = ""
                심혈관계.setTextColor(Color.BLACK)
                심혈관계.textSize = 12f
            }
        }
        면역기계.setOnClickListener {
            if (면역기계_text == "false") {
                면역기계_text = "true"
                면역기계.text = "V"
                면역기계.setTextColor(Color.parseColor("#82FFFF"))
                면역기계.textSize = 60f
            } else {
                면역기계_text = "false"
                면역기계.text = ""
                면역기계.setTextColor(Color.BLACK)
                면역기계.textSize = 12f
            }
        }
        호흡기계.setOnClickListener {
            if (호흡기계_text == "false") {
                호흡기계_text = "true"
                호흡기계.text = "V"
                호흡기계.setTextColor(Color.parseColor("#82FFFF"))
                호흡기계.textSize = 60f
            } else {
                호흡기계_text = "false"
                호흡기계.text = ""
                호흡기계.setTextColor(Color.BLACK)
                호흡기계.textSize = 12f
            }
        }
        계절성알레르기.setOnClickListener {
            if (계절성알레르기_text == "false") {
                계절성알레르기_text = "true"
                계절성알레르기.text = "V"
                계절성알레르기.setTextColor(Color.parseColor("#82FFFF"))
                계절성알레르기.textSize = 60f
            } else {
                계절성알레르기_text = "false"
                계절성알레르기.text = ""
                계절성알레르기.setTextColor(Color.BLACK)
                계절성알레르기.textSize = 12f
            }
        }
        체중관리.setOnClickListener {
            if (체중관리_text == "false") {
                체중관리_text = "true"
                체중관리.text = "V"
                체중관리.setTextColor(Color.parseColor("#82FFFF"))
                체중관리.textSize = 60f
            } else {
                체중관리_text = "false"
                체중관리.text = ""
                체중관리.setTextColor(Color.BLACK)
                체중관리.textSize = 12f
            }
        }
        수면.setOnClickListener {
            if (수면_text == "false") {
                수면_text = "true"
                수면.text = "V"
                수면.setTextColor(Color.parseColor("#82FFFF"))
                수면.textSize = 60f
            } else {
                수면_text = "false"
                수면.text = ""
                수면.setTextColor(Color.BLACK)
                수면.textSize = 12f
            }
        }
        val 다음 = findViewById<Button>(R.id.다음)
        다음.setOnClickListener {
            saveTextToDatabase(귀_청력_text, 대장_text, 모발_피부_text, 에너지_text, 심혈관계_text,면역기계_text, 호흡기계_text, 계절성알레르기_text, 체중관리_text, 수면_text)
            val intent = Intent(this, signupActivity4::class.java)
            startActivity(intent)}

        /*
        for (i in 30..39) {
            buttonStates[i] = false
        }

        for (i in 30..39) {
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

                val 다음 = findViewById<Button>(R.id.다음)
                다음.setOnClickListener {
                    saveTextToDatabase(귀_청력_text, 대장_text, 모발_피부_text, 에너지_text, 심혈관계_text,면역기계_text, 호흡기계_text, 계절성알레르기_text, 체중관리_text, 수면_text)
                    val intent = Intent(this, InputActivity3::class.java)
                    startActivity(intent)

                }
            }
        }*/
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