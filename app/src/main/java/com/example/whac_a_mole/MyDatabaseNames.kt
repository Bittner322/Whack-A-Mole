package com.example.whac_a_mole

import android.provider.BaseColumns
//класс для упрощения работы с БД
class MyDatabaseNames {

    companion object {
        const val TABLE_NAME = "player_records"
        const val COLUMN_RECORDS = "RECORDS"
        const val DATABASE_VERSION = 4
        const val DATABASE_NAME = "records.db"
        const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ${Companion.TABLE_NAME} (" + "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_RECORDS INTEGER)"
        const val DROP_TABLE = "DROP TABLE IF EXISTS player_records"
    }

}