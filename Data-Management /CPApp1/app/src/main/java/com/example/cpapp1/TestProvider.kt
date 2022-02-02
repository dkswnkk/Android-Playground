package com.example.cpapp1

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.util.Log

class TestProvider : ContentProvider() {

    var db: SQLiteDatabase? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val cnt = db?.delete("TestTable", selection, selectionArgs)
        return cnt!!
    }


    // 열의 데이터 타입을 MIME 타입 형태로 반환하는 메서드
    // 알려줄 필요가 없다면 null을 반환한다.
    // 이미 db설계를 할떄 타입을 지정해줬기 때문에 개발자가 타입을 모를 리가 없
    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        db?.insert("TestTable", null, values)
        return uri
    }

    // Content Provider 객체가 생성되면 자동으로 호출되는 메서드
    // 데이터베이스에 접할 수 있는 객체를 생성하고
    // 접속에 성공하면 true, 실패하면 false를 반환해준다.
    override fun onCreate(): Boolean {
        Log.d("test", "생성")
        db = DBHelper(context!!).writableDatabase
        return db != null
    }

    // select용
    // uri: provider 요청시 사용한 uri 값
    // projection: 가져올 column 이름 목록, null이면 모든 column을 가져온다.
    // selection: 조건절, null이면 조건이 없다.
    // selectionArgs: 조건절의 ?에 바인딩 될 값 배열
    // sortOrder: 정렬 기준이 되는 column
    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        Log.d("test", "호출")
        return db?.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val cnt = db?.update("TestTable", values, selection, selectionArgs)
        return cnt!!
    }
}