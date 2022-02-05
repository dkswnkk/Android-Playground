package com.example.memoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.MainRecyclerRowBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val subject_list = ArrayList<String>()
    val date_list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        SystemClock.sleep(1000)
        // Splash 화면 이후로 보여질 화면의 테마를 설정한다.
        setTheme(R.style.Theme_MemoApp)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val helper = DBHelper(this).writableDatabase.close()

        // Toolbar 설정
        setSupportActionBar(binding.mainToolbar)
        title = "메모 앱"


        // RecyclerView 셋팅
        val main_recycler_adapter = MainRecyclerAdapter()
        binding.mainRecycler.adapter = main_recycler_adapter

        binding.mainRecycler.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_menu_add -> {
                val memo_add_intent = Intent(this, MemoAddActivity::class.java)
                startActivity(memo_add_intent)
            }
        }
        return true
    }

    override fun onResume() {
        super.onResume()

        subject_list.clear()
        date_list.clear()

        // 데이터 베이스 오픈
        val helper = DBHelper(this)
        val sql = """
            select memo_subject, memo_date
            from MemoTable
            order by memo_idx desc
        """.trimIndent()

        val c1 = helper.writableDatabase.rawQuery(sql, null)

        while (c1.moveToNext()) {
            val idx1 = c1.getColumnIndex("memo_subject")
            val idx2 = c1.getColumnIndex("memo_date")
            val memo_subject = c1.getString(idx1)
            val memo_date = c1.getString(idx2)

            subject_list.add(memo_subject)
            date_list.add(memo_date)

            // RecyclerView 갱신
            binding.mainRecycler.adapter?.notifyDataSetChanged()
        }
    }

    // RecyclerView의 어댑터
    inner class MainRecyclerAdapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolderClass>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            val mainReCyclerBinding = MainRecyclerRowBinding.inflate(layoutInflater)
            val holder = ViewHolderClass(mainReCyclerBinding)
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowMemoSubject.text = subject_list[position]
            holder.rowMemoDate.text = date_list[position]
        }

        override fun getItemCount(): Int {
            return subject_list.size
        }

        // HolderClass
        inner class ViewHolderClass(mainReCyclerBinding: MainRecyclerRowBinding) :
            RecyclerView.ViewHolder(mainReCyclerBinding.root) {
            // View의 주소값을 담는다.
            val rowMemoSubject = mainReCyclerBinding.memoSubject
            val rowMemoDate = mainReCyclerBinding.memoDate
        }
    }
}