package com.example.whac_a_mole

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//Класс для непосредственно создания бд
class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, MyDatabaseNames.DATABASE_NAME, null, MyDatabaseNames.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDatabaseNames.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(MyDatabaseNames.DROP_TABLE)
        onCreate(db)
    }
}