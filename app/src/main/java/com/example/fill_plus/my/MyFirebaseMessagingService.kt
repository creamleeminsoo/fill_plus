package com.example.fill_plus.my

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.fill_plus.R
import com.example.fill_plus.main.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val TAG = "FirebaseMsgService"

    private var msg: String? = null
    private var title: String? = null

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.e(TAG, "onMessageReceived")

        title = remoteMessage.notification?.title
        msg = remoteMessage.notification?.body

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val contentIntent = PendingIntent.getActivity(
            this, 0,
            Intent(this, MainActivity::class.java), PendingIntent.FLAG_IMMUTABLE
        )

        val mBuilder = NotificationCompat.Builder(this, "default")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(msg)
            .setAutoCancel(true)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setVibrate(longArrayOf(1, 1000))

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(0, mBuilder.build())

        mBuilder.setContentIntent(contentIntent)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // 등록 토큰 처리 작업 수행
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
        Log.d(TAG, "Registration Token: $token")
        // 등록 토큰 서버로 전송하는 작업 수행
    }


}








