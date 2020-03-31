package com.example.lab4_test

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Lab4Task3 : AppCompatActivity() {

    //Викликаємо об'єкт FragmentManager для управління фрагментами
    private var manager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_task3)

        //Отримуємо посилання на елементи ViewPager і TabLayout
        val pager: ViewPager = findViewById(R.id.pager)
        val tabLayout: TabLayout = findViewById(R.id.tabs)

        pager.adapter = MyAdapter(manager) //Адаптер постачає віджету фрагменти
        pager.setPageTransformer(false, ZoomOutPageTransformer()) //Анімація зміни фрагментів

        tabLayout.setupWithViewPager(pager) //Метод налаштовує використання TabLayout спільно з ViewPager
    }

    //Клас для управління фрагментами
    @Suppress("DEPRECATION")
    class MyAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        //Заголовок фрагменту
        @Nullable
        override fun getPageTitle(position: Int): CharSequence = "FRAGMENT" + (position+1).toString()
        //Повертає об'єкт i-го фрагмента
        override fun getItem(i: Int): Fragment = DetailsFragmentTask3.newInstance("image" + (i+1).toString())
        //Кількість фрагментів
        override fun getCount(): Int = 3
    }
}
