package com.example.lab4_test

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

    //Викликається в момент приєднання Activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException(
                "$context must implement OnFragmentInteractionListener"
            )
        }
    }

    //Викликається в момент від'єднання фрагмента
    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(result: String?)
    }

    //Викликається в момент створення дерева елементів графічного інтерфейсу
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    //Викликається вже після успішного створення графічного інтерфейсу макета
    override fun onViewCreated(@NonNull view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Обробники натискання кнопок
        //Виклик метода Activity і відправка даних
        view.findViewById<Button>(R.id.buttonGoogle).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.google.com/")
        }
        view.findViewById<Button>(R.id.buttonFacebook).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.facebook.com/")
        }
        view.findViewById<Button>(R.id.buttonTwitter).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.twitter.com/")
        }
        view.findViewById<Button>(R.id.buttonXda).setOnClickListener {
            mListener?.onFragmentInteraction("http://www.xda-developers.com/")
        }
    }
}
