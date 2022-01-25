package com.example.messagenotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import com.example.messagenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val builder1 =
                    getNotificationbuilder("message", "메세지 스타일").setContentTitle("Message Style")
                        .setContentText("Message Style Notification")
                        .setSmallIcon(android.R.drawable.ic_input_delete)


                val personBuilder1 = Person.Builder()
                    .setIcon(IconCompat.createWithResource(this, android.R.drawable.ic_media_next))
                    .setName("홍길동").build()

                val personBuilder2 = Person.Builder()
                    .setIcon(IconCompat.createWithResource(this, android.R.drawable.arrow_up_float))
                    .setName("아무개").build()

                val messageStyle = NotificationCompat.MessagingStyle(personBuilder1)
                    .addMessage("첫번쨰 메지시", System.currentTimeMillis(), personBuilder1)
                    .addMessage("두번쨰 메시지", System.currentTimeMillis(), personBuilder2)
                    .addMessage("세번쨰 메시지",System.currentTimeMillis(),personBuilder1)
                    .addMessage("네번째 메시지",System.currentTimeMillis(),personBuilder2)
                builder1.setStyle(messageStyle)


                val notification = builder1.build()
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.notify(10, notification)


            }
        }

    }

    fun getNotificationbuilder(id: String, name: String): NotificationCompat.Builder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val channel = NotificationChannel(
                "message",
                "Message Stylle",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)
            NotificationCompat.Builder(this, id)
        } else {
            NotificationCompat.Builder(this)
        }
    }
}