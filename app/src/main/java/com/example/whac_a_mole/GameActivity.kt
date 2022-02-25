package com.example.whac_a_mole

import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    private lateinit var timerTv: TextView

    private lateinit var imgBtn0: ImageButton
    private lateinit var imgBtn1: ImageButton
    private lateinit var imgBtn2: ImageButton
    private lateinit var imgBtn3: ImageButton
    private lateinit var imgBtn4: ImageButton
    private lateinit var imgBtn5: ImageButton

    private lateinit var counterTv: TextView

    private var count: Int = 0

    //CountDownTimer, основной механизм игры
    private val timer = object: CountDownTimer(30000,500) {
        override fun onTick(millisUntilFinished: Long) {

            timerTv.text = "0" + ":" + (millisUntilFinished / 1000)

            when ((0..5).random()) {
                0 -> {
                    imgBtn0.isEnabled = true
                    imgBtn0.background = getDrawable(R.drawable.mole)
                    Handler().postDelayed({
                        imgBtn0.background = ColorDrawable(Color.TRANSPARENT)
                        imgBtn0.isEnabled = false
                    },500)
                }
                1 -> {
                    imgBtn1.isEnabled = true
                    imgBtn1.background = getDrawable(R.drawable.mole)
                    Handler().postDelayed({
                        imgBtn1.background = ColorDrawable(Color.TRANSPARENT)
                        imgBtn1.isEnabled = false
                    },500)
                }
                2 -> {
                    imgBtn2.isEnabled = true
                    imgBtn2.background = getDrawable(R.drawable.mole)
                    Handler().postDelayed({
                        imgBtn2.background = ColorDrawable(Color.TRANSPARENT)
                        imgBtn2.isEnabled = false
                    },500)
                }
                3 -> {
                    imgBtn3.isEnabled = true
                    imgBtn3.background = getDrawable(R.drawable.mole)
                    Handler().postDelayed({
                        imgBtn3.background = ColorDrawable(Color.TRANSPARENT)
                        imgBtn3.isEnabled = false
                    },500)
                }
                4 -> {
                    imgBtn4.isEnabled = true
                    imgBtn4.background = getDrawable(R.drawable.mole)
                    Handler().postDelayed({
                        imgBtn4.background = ColorDrawable(Color.TRANSPARENT)
                        imgBtn4.isEnabled = false
                    },500)
                }
                5 -> {
                    imgBtn5.isEnabled = true
                    imgBtn5.background = getDrawable(R.drawable.mole)
                    Handler().postDelayed({
                        imgBtn5.background = ColorDrawable(Color.TRANSPARENT)
                        imgBtn5.isEnabled = false
                    },500)
                }
            }
        }

        override fun onFinish() {
            //запись в дб текущего результата и вывод лучшего рекорда
            myDbManager.openDb()
            myDbManager.insertToDb(count)
            val records = myDbManager.readDbData()
            val maxRecord = records.maxOrNull() ?: 0

            val endGameIntent = Intent(this@GameActivity, FinishedGameActivity::class.java).apply {
                putExtra("countOfPoints", count)
                putExtra("maxRecord", maxRecord)
            }
            startActivity(endGameIntent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        timer.start()

        imgBtn0 = findViewById(R.id.imgBtn0)
        imgBtn1 = findViewById(R.id.imgBtn1)
        imgBtn2 = findViewById(R.id.imgBtn2)
        imgBtn3 = findViewById(R.id.imgBtn3)
        imgBtn4 = findViewById(R.id.imgBtn4)
        imgBtn5 = findViewById(R.id.imgBtn5)

        timerTv = findViewById(R.id.timerTv)

        counterTv = findViewById(R.id.counterTv)

        counterTv.text = count.toString()
    }

    //обработка кликов на кротов

    fun imgBtn0Click(view: View) {
        count += 1
        counterTv.text = count.toString()
    }

    fun imgBtn1Click(view: View) {
        count += 1
        counterTv.text = count.toString()
    }
    fun imgBtn2Click(view: View) {
        count += 1
        counterTv.text = count.toString()
    }
    fun imgBtn3Click(view: View) {
        count += 1
        counterTv.text = count.toString()
    }
    fun imgBtn4Click(view: View) {
        count += 1
        counterTv.text = count.toString()
    }
    fun imgBtn5Click(view: View) {
        count += 1
        counterTv.text = count.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}