package com.example.fill_plus.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fill_plus.my.MyActivity1
import com.example.fill_plus.R
import java.util.Calendar

class AlarmActivity : AppCompatActivity() {
    private lateinit var alarmManager: AlarmManager
    private lateinit var timePicker: TimePicker
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alram)
        val button2 = findViewById<Button>(R.id.중성)
        button2.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java)
            startActivity(intent)
        }

        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        timePicker = findViewById(R.id.timePicker)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            setAlarm()
        }
    }

    private fun setAlarm() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.add(Calendar.SECOND, 10)

        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        Toast.makeText(this, "알람이 설정되었습니다.", Toast.LENGTH_SHORT).show()
    }


}






