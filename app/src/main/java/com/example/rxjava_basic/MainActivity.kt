package com.example.rxjava_basic

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Transformations.map
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG = "MainActivityRxJava"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxJavaBasicsShow()
    }

    //Save Subscrbtion
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    private fun rxJavaBasicsShow() {

        //Observable
       val observable: Observable<String> = Observable.just("hello world","from Androidchef")

        //observer
        val observer = object : Observer<String> {
            override fun onComplete() {
                Log.d(TAG,"onComplete")
            }

            override fun onSubscribe(d: Disposable?) {
                //saving Subscription
                compositeDisposable.add(d)
                Log.d(TAG,"onSubscribe")
            }

            override fun onNext(t: String?) {
                Log.d(TAG,"onNext data = $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG,"onError Exception = ${e?.localizedMessage}")
            }
        }
        //Changing value Observable
        observable
                .map { it.toUpperCase(Locale.getDefault()) } //Transformation (Converting to UpperCase)
                .subscribe(observer) //Subscription and execution handled by Observable
    }

    override fun onDestroy(){
        super.onDestroy()

        //check if alerady destroy or not
        if(compositeDisposable.isDisposed.not()){
            compositeDisposable.dispose()
        }

    }
}