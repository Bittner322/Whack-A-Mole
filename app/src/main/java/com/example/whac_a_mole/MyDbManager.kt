package com.example.whac_a_mole

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
//класс для взаимодействия с БД
class MyDbManager(context: Context) {
    private val myDbHelper = MyDatabaseHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(record: Int) {
        val values = ContentValues().apply {
            put(MyDatabaseNames.COLUMN_RECORDS, record)
        }
        db?.insert(MyDatabaseNames.TABLE_NAME, null, values)
    }
    fun readDbData() : ArrayList<Int> {
        val dataList = ArrayList<Int>()
        val cursor = db?.query(MyDatabaseNames.TABLE_NAME, null, null, null, null, null, null)

        //!!! если строку с инициализацией dataText подчеркивает красным, это не ошибка, это баг андроид студии, все работает :)

        while(cursor?.moveToNext()!!) {
            val dataText = cursor.getInt(cursor.getColumnIndex(MyDatabaseNames.COLUMN_RECORDS))
            dataList.add(dataText)
        }
        return dataList
    }

    fun closeDb() {
        myDbHelper.close()
    }
}