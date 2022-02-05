package com.example.socketclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.socketclient.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            thread {
                // 서버에 접속한다.
                val socket = Socket("2001:2d8:6440:d785:f8b4:34f7:491e:cd4d", 22222)

                Log.d("test", "${socket}")

                // 서버로 부터 데이터를 수신한다.
                val inputStream = socket.getInputStream()
                val dis = DataInputStream(inputStream)

                val a1 = dis.readInt()
                val a2 = dis.readDouble()
                val a3 = dis.readBoolean()
                val a4 = dis.readUTF()


                // 개발자가 발생 시킨 UI스레드에서 화면 작업을 하기 위해 runOnUiThread 메소드 사용
                runOnUiThread {
                    binding.textView.text = "${a1}\n"
                    binding.textView.append("${a2}\n")
                    binding.textView.append("${a3}\n")
                    binding.textView.append("${a4}\n")
                }

                // 서버로 데이터를 보낸다.
                val outputStream = socket.getOutputStream()
                val dos = DataOutputStream(outputStream)

                dos.writeInt(200)
                dos.writeUTF("클라이언트에서 보내는 문자열")
                socket.close()
            }
        }
    }
}