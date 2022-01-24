package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder1 = getNotificationBuilder(
                "channel1",
                "첫 번쨰 채널"
            ).setSmallIcon(android.R.drawable.ic_menu_search)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
                .setNumber(100).setContentTitle("Content Title 1").setContentText("Content Text 1")
            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        binding.button2.setOnClickListener {
            val builder1 = getNotificationBuilder(
                "channel1",
                "첫 번쨰 채널"
            ).setSmallIcon(android.R.drawable.ic_menu_search)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
                .setNumber(100).setContentTitle("Content Title 2").setContentText("Content Text 2")
            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }
        binding.button3.setOnClickListener {
            val builder1 = getNotificationBuilder(
                "channel1",
                "첫 번쨰 채널"
            ).setSmallIcon(android.R.drawable.ic_menu_search)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
                .setNumber(100).setContentTitle("Content Title 3").setContentText("Content Text 3")
            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }
        binding.button4.setOnClickListener {
            val builder1 = getNotificationBuilder(
                "channel1",
                "첫 번쨰 채널"
            ).setSmallIcon(android.R.drawable.ic_menu_search)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
                .setNumber(100).setContentTitle("Content Title 4").setContentText("Content Text 4")
            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(40, notification)
        }
    }

    // 안드로이드 8.0 이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드
    fun getNotificationBuilder(id: String, name: String): NotificationCompat.Builder {

        // os 버전별로 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 알림 메시지를 관리하는 객체를 호출한다.
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            // 메세지 출력시 단말기 LED를 사용할 것인가..
            channel.enableLights(true)
            // LED 색상 설정
            channel.lightColor = Color.RED
            // 진동 사용 여부
            channel.enableVibration(true)
            //알림 메세지를 관리하는 객체에 채널을 등록한다.
            manager.createNotificationChannel(channel)
            return NotificationCompat.Builder(this, id)
        } else {
            return NotificationCompat.Builder(this)
        }
    }
}