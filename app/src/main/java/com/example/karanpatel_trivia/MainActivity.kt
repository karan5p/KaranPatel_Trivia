package com.example.karanpatel_trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClick(v:View?){
        if(v != null){
            when(v.id){
                btnPlay.id ->{
                    this.getQuiz()
                }
            }
        }
    }
    fun getQuiz(){

    }

}