package com.example.lab4_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class DetailsFragmentTask2() : Fragment() {

    private var mParam1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mParam1 = it.getString(ARG_PARAM1)
        }
    }

    //Метод зворотного виклику, який система Android викликає, коли для фрагмента настає час відобразити свій макет
    override fun onCreateView(@NonNull inflater: LayoutInflater, @NonNull container: ViewGroup?, @NonNull savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_task2, container, false)
    }

    //У методі встановлюємо значення полів, які були передані за допомогою механізму Arguments
    override fun onViewCreated(@NonNull view: View, @NonNull savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView: WebView = view.findViewById(R.id.webView)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl(mParam1)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String?): DetailsFragmentTask2 {
            val fragment = DetailsFragmentTask2()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
