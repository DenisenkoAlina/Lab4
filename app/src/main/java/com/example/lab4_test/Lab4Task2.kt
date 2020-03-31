package com.example.lab4_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class Lab4Task2 : AppCompatActivity(), MenuFragment.OnFragmentInteractionListener {

    //Викликаємо об'єкт FragmentManager для управління фрагментами
    private var manager: FragmentManager? = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_task2)

        manager?.beginTransaction()?.add(R.id.frame1, MenuFragment(), "flag1")?.commit()
    }

    //Метод для обробки натискання кнопки в MenuFragment
    override fun onFragmentInteraction(result: String?) {
        //Додаємо фрагмент DetailsFragmentTask2
        manager?.beginTransaction()?.add(R.id.frame2, DetailsFragmentTask2.newInstance(result), "flag2")?.commit()
    }
}
