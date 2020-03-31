package com.example.lab4_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when ((view as Button).id) {
            //Макет з 4х фрагментів, в залежності від орієнтації використовується альтернативний макет з іншого компонуванням фрагментів
            R.id.task1 -> startActivity(Intent(this, Lab4Task1::class.java))
            //2 фрагмента в Activity, при натисканні на пнк списку в лівому фрагменті відкривається правий фрагмент з елементом WebView
            R.id.task2 -> startActivity(Intent(this, Lab4Task2::class.java))
            //Додаток з віджетами ViewPager і TabLayout
            R.id.task3 -> startActivity(Intent(this, Lab4Task3::class.java))
        }
    }
}
