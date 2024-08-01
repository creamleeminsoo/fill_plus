package com.example.fill_plus.main










import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.fill_plus.R

import com.google.firebase.database.FirebaseDatabase

// Firebase Realtime Database의 "dsld/nutrients"에서 데이터 불러오기





class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        var database = FirebaseDatabase.getInstance()

        var new1 = database.getReference("dsld/nutrient_1000")
        var new2 = database.getReference("dsld/nutrient_1002")

        val button1 = findViewById<Button>(R.id.button_1)
        val button100 = findViewById<Button>(R.id.fixedButton1)
        val chk_button_1 = findViewById<Button>(R.id.chk_button_1) //비교버튼 누르면 v 뜨게
        val button17 = findViewById<Button>(R.id.button_17) //비교버튼 누르면 v 뜨게
        val button18 = findViewById<Button>(R.id.button_18) //비교버튼 누르면 v 뜨게
        val button19 = findViewById<Button>(R.id.button_19) //비교버튼 누르면 v 뜨게
        val button20 = findViewById<Button>(R.id.button_20) //비교버튼 누르면 v 뜨게
        val button21 = findViewById<Button>(R.id.button_21) //비교버튼 누르면 v 뜨게
        val button22 = findViewById<Button>(R.id.button_22) //비교버튼 누르면 v 뜨게
        val button23 = findViewById<Button>(R.id.button_23) //비교버튼 누르면 v 뜨게
        val button24 = findViewById<Button>(R.id.button_24) //비교버튼 누르면 v 뜨게
        val button25 = findViewById<Button>(R.id.button_25) //비교버튼 누르면 v 뜨게
        val button26 = findViewById<Button>(R.id.button_26) //비교버튼 누르면 v 뜨게
        val button27 = findViewById<Button>(R.id.button_27) //비교버튼 누르면 v 뜨게
        val button28 = findViewById<Button>(R.id.button_28) //비교버튼 누르면 v 뜨게
        val button29 = findViewById<Button>(R.id.button_29) //비교버튼 누르면 v 뜨게
        val button30 = findViewById<Button>(R.id.button_30) //비교버튼 누르면 v 뜨게
        val button200 = findViewById<ImageButton>(R.id.fixedButton2)

        button200.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java) // 인텐트 생성
            startActivity(intent) // 다음 액티비티 시작
        }








        button1.setOnClickListener {

            chk_button_1.setOnClickListener {
                if (chk_button_1.text == "ㅤ") {
                    chk_button_1.text = "V"
                } else {
                    chk_button_1.text = "ㅤ"
                }
            }
            button17.setOnClickListener {
                if (button17.text == "ㅤ") {
                    button17.text = "V"
                } else {
                    button17.text = "ㅤ"
                }
            }
            button18.setOnClickListener {
                if (button18.text == "ㅤ") {
                    button18.text = "V"
                } else {
                    button18.text = "ㅤ"
                }
            }
            button19.setOnClickListener {
                if (button19.text == "ㅤ") {
                    button19.text = "V"
                } else {
                    button19.text = "ㅤ"
                }
            }
            button20.setOnClickListener {
                if (button20.text == "ㅤ") {
                    button20.text = "V"
                } else {
                    button20.text = "ㅤ"
                }
            }
            button21.setOnClickListener {
                if (button21.text == "ㅤ") {
                    button21.text = "V"
                } else {
                    button21.text = "ㅤ"
                }
            }
            button22.setOnClickListener {
                if (button22.text == "ㅤ") {
                    button22.text = "V"
                } else {
                    button22.text = "ㅤ"
                }
            }
            button23.setOnClickListener {
                if (button23.text == "ㅤ") {
                    button23.text = "V"
                } else {
                    button23.text = "ㅤ"
                }
            }
            button24.setOnClickListener {
                if (button24.text == "ㅤ") {
                    button24.text = "V"
                } else {
                    button24.text = "ㅤ"
                }
            }
            button25.setOnClickListener {
                if (button25.text == "ㅤ") {
                    button25.text = "V"
                } else {
                    button25.text = "ㅤ"
                }
            }
            button26.setOnClickListener {
                if (button26.text == "ㅤ") {
                    button26.text = "V"
                } else {
                    button26.text = "ㅤ"
                }
            }
            button27.setOnClickListener {
                if (button27.text == "ㅤ") {
                    button27.text = "V"
                } else {
                    button27.text = "ㅤ"
                }
            }
            button28.setOnClickListener {
                if (button28.text == "ㅤ") {
                    button28.text = "V"
                } else {
                    button28.text = "ㅤ"
                }
            }
            button29.setOnClickListener {
                if (button29.text == "ㅤ") {
                    button29.text = "V"
                } else {
                    button29.text = "ㅤ"
                }
            }
            button30.setOnClickListener {
                if (button30.text == "ㅤ") {
                    button30.text = "V"
                } else {
                    button30.text = "ㅤ"
                }
            }




            if (button100.text == "ㅤ") {
                button100.text = "확인"
            } else {
                button100.text = "ㅤ"
            }
            button100.setOnClickListener {
                val buttons = arrayOf(chk_button_1, button17, button18, button19, button20, button21, button22, button23, button24, button25, button26, button27, button28, button29, button30)
                if (buttons.count { it.text == "V" } == 2) {
                    val intent = Intent(this, MainActivity5::class.java) // 인텐트 생성
                    startActivity(intent) // 다음 액티비티 시작
                }
            }







        }





    }




}





