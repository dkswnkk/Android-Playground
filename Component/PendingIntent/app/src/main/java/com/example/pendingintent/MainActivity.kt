package com.example.pendingintent

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.pendingintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val pending1 = PendingIntent.getActivity(
                this,
                10,
                Intent(this, NotificationActivity1::class.java).putExtra("data1", 100)
                    .putExtra("data2", 200),
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            val builder1 = getNotificationBuilder(
                "pending",
                "pending intent"
            ).setContentTitle("notification 1").setContentText("알림 메시지 1")
                .setSmallIcon(android.R.drawable.ic_menu_search)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                .setContentIntent(pending1).setAutoCancel(true)

            // Action 설정

            val intent2 = Intent(this, ActivityNotification3::class.java)
            val pending2 = PendingIntent.getActivity(this,100,intent2,PendingIntent.FLAG_UPDATE_CURRENT)
            val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass,"Action1",pending2)
            val action2 = builder2.build()
            builder1.addAction(action2)

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
            
        }
        binding.button2.setOnClickListener {

            // 메세지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val pending1 = PendingIntent.getActivity(
                this,
                10,
                Intent(this, NotificationActivity2::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            val builder1 = getNotificationBuilder(
                "pending",
                "pending intent"
            ).setContentTitle("notification 2").setContentText("알림 메시지 2")
                .setSmallIcon(android.R.drawable.ic_menu_search)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                .setContentIntent(pending1)
            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }
    }

    fun getNotificationBuilder(id: String, name: String): NotificationCompat.Builder {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
            return NotificationCompat.Builder(this, id)
        } else {
            return NotificationCompat.Builder(this)
        }
    }
}