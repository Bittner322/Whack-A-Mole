package com.example.whac_a_mole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startGameClick(view: View) {
        var intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}