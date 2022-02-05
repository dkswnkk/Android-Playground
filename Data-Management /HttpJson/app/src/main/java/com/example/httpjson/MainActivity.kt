package com.example.httpjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.httpjson.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
//            thread {
//                val url = URL("https://jsonplaceholder.typicode.com/users")
//                val conn = url.openConnection() as HttpURLConnection
//                Log.d("test","1")
//                Log.d("test","${conn}")
//                val br = BufferedReader(InputStreamReader(conn.inputStream, "UTF-8"))
//
//                var str:String? = null
//                val buf = StringBuffer()
//
//                while(true){
//                    var str: String? = br.readLine() ?: break
//                    buf.append(str)
//                }
//
//                Log.d("test","${buf}")
//
//
//            }

            try{
                Log.d("test","1")
                val assetManagere = resources.assets
                val inputStream = assetManagere.open("Movier.json")
                val jsonString = inputStream.bufferedReader().use{it.readText()}

                val jsonObject = JSONObject(jsonString)
                val jsonArray = jsonObject.getJSONArray("Movies")
                Log.d("test","${jsonArray}")
                binding.textView.text = ""
                for(i in 0 until jsonArray.length()){
                    val obj = jsonArray.getJSONObject(i)
                    binding.textView.append("${i}번째 영화 타이틀 ${obj.getString("title")}\n")
                    binding.textView.append("${i}번째 영화 타이틀 ${obj.getString("grade")}\n")
                    binding.textView.append("${i}번째 영화 타이틀 ${obj.getString("category")}\n")
                    binding.textView.append("\n")
                }

            } catch (e:JSONException){
                e.printStackTrace()
            }
        }
    }
}