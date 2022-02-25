package com.example.whac_a_mole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FinishedGameActivity : AppCompatActivity() {
//активити с завершенной игрой, где выводятся текущий результат и рекорд
    private lateinit var resultTv: TextView
    private lateinit var recordTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished_game)

        resultTv = findViewById(R.id.resultTv)
        recordTv = findViewById(R.id.recordTv)

        val gameResult = intent.getIntExtra("countOfPoints", 0)
        val maxRecord = intent.getIntExtra("maxRecord", 0)

        resultTv.text = "Ваш счет: $gameResult"
        recordTv.text = "Ваш рекорд: $maxRecord"
    }

    fun playAgainClick(view: View) {
        var playAgainIntent = Intent(this@FinishedGameActivity, GameActivity::class.java)
        startActivity(playAgainIntent)
        finish()
    }
    fun toMenuClick(view: View) {
        var toMenuIntent = Intent(this@FinishedGameActivity, MainActivity::class.java)
        startActivity(toMenuIntent)
        finish()
    }
}