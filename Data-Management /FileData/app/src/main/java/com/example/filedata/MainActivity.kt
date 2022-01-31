package com.example.filedata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.example.filedata.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    // 내부 저장소의 앱 데이터 디렉토리의 경로
    lateinit var file_path: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // null값을 넣으면 앱 데이터 폴더의 경로를 얻어온다.
        file_path = getExternalFilesDir(null).toString()
//        file_path = getExternalFilesDir(Environment.DIRECTORY_MUSIC).toString()
        Log.d("test", file_path)


        binding.button.setOnClickListener {
            // MODE_PRIVATE: 덮어씌우기
            // MODE_APPEND: 이어서 쓰기
            val fos = openFileOutput("data1.dat", Context.MODE_PRIVATE)
            val dos = DataOutputStream(fos)

            // 데이터를 쓴다.
//            dos.writeInt(100)
//            dos.writeDouble(100.0)
//            dos.writeBoolean(false)
            dos.writeUTF("스트링")
            dos.flush()
            dos.close()

            binding.textView.text = "내부 저장소 쓰기 완료"
        }

        binding.button2.setOnClickListener {
            val fis = openFileInput("data1.dat")
            val dis = DataInputStream(fis)

//            val data1 = dis.readDouble()
            val data2 = dis.readUTF()
//            dis.close()

            binding.textView.text = data2
            Log.d("test",data2)
        }
        binding.button3.setOnClickListener {
            val fos = FileOutputStream("${file_path}/data2.dat")
            val dos = DataOutputStream(fos)
            dos.writeInt(1000)
            dos.flush()
            dos.close()
            binding.textView.text = "외부 저장소의 앱 데이터 폴더에 저장"
        }
        binding.button4.setOnClickListener {
            val fis = FileInputStream("${file_path}/data2.dat")
            val dis = DataInputStream(fis)
            val data1 = dis.readInt()
            binding.textView.text = data1.toString()
        }
        binding.button5.setOnClickListener {
            // 파일 관리 앱의 액티비티를 실행한다.
            val fileIntent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE)
            fileIntent.type="*/*"   //모든 타입을 볼때

            startActivityForResult(fileIntent,100)
        }
        binding.button6.setOnClickListener {
            // 파일 관리 앱의 액티비티를 실행한다.
            val fileIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            fileIntent.type="*/*"
            startActivityForResult(fileIntent,200)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            100->{
                if(resultCode == RESULT_OK){
                    val des1 = contentResolver.openFileDescriptor(data?.data!!,"w")
                    val fos = FileOutputStream(des1?.fileDescriptor)
                    val dos = DataOutputStream(fos)

                    dos.writeUTF("zzzzzzzzz")
                    dos.flush()
                    dos.close()
                    binding.textView.text="다운로드 폴더에 저장"
                }
            }
            200->{
                if(resultCode== RESULT_OK){
                    val des2 = contentResolver.openFileDescriptor(data?.data!!,"r")
                    val fis = FileInputStream(des2?.fileDescriptor)
                    val dis = DataInputStream(fis)

                    binding.textView.text = dis.readUTF()
                }
            }
        }
    }
}