package com.example.ipc

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.ipc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 접속한 서비스 객체
    var ipcService: TestService? = null

    // 서비스 접속을 관리하는 객체
    val connection = object : ServiceConnection {
        // 서비스에 접속이 성공했을 때
        // 두번째: 서비스의 onBind 메서드가 반환하는 객체를 받는다.
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            //서비스를 추출한다.
            val binder = p1 as TestService.LocalBinder
            ipcService = binder.getService()
        }

        // 서비스 접속을 해제했을
        override fun onServiceDisconnected(p0: ComponentName?) {
            ipcService = null
        }
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 서비스가 가동중이 아니라면 서비스를 가동한다.
        val chk = isServiceRunning("com.example.ipc.TestService")
        val serviceIntent = Intent(this, TestService::class.java)
        if (chk == false) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }
        // 서비스에 접속한다.
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)


        binding.button.setOnClickListener {
            var value = ipcService?.getNumber()
            binding.textView.text = "${value}"
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // 접속한 서비스에 접속을 해제한다.
        unbindService(connection)
    }


    // 서비스 실행 여부를 검사하는 메서드
    fun isServiceRunning(name: String): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

        for (serviceInfo in serviceList) {
            if (serviceInfo.service.className == name) {
                return true
            }
        }
        return false
    }
}