package com.example.rxjava_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjava_basic.R
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxJavaBasicsShow()
    }

    private fun rxJavaBasicsShow() {

        //Observable
       val observable: Observable<String> = Observable.just("hello world","from Androidchef")

    }
}