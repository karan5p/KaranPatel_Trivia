package com.example.karanpatel_trivia

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    fun insertQuestion(question: Question) = viewModelScope.launch(Dispatchers.IO){

    }


}