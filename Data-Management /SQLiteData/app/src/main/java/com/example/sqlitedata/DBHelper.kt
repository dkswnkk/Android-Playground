package com.example.sqlitedata

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(
        context,
        "Test.db", null, 1
    )

    // 데이터 베이스 파일이 없을 겨우 파일을마들고 자동으로 호출된다.
    // 어플리케이션 설치 후 최초로 접근시 호출
    // 최신 형태의 테이블을 생성하는 쿼리문을 작성한다.
    override fun onCreate(p0: SQLiteDatabase?) {
        Log.d("test", "데이터베이스가 생성 되었습니다.")
        val sql = """
            create table TestTable
                (idx integer primary key autoincrement,
                 textData text not null,
                 intData integer not null,
                 floatData real not null,
                 dateData date not null)
        """.trimIndent()
        p0?.execSQL(sql)
    }

    // 버전이 변경된 경우 호출된다.
    // 기존에 앱을 사용하는 사용자를 위해 테이블의 구조를 최신 형태로 만들어주는 쿼리문을 작성한다.
    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("test", "${oldVersion}->${newVersion}")
//        when (oldVersion) {
//            1 -> {
//
//            }
//            2 -> {
//
//            }
//            3 -> {
//
//            }
//        }
    }
}