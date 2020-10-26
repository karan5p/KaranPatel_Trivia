package com.example.karanpatel_trivia.database
//991519115 Karan Patel A2
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    private val questionRepo : QuestionRepository
    var allQuestions:LiveData<Array<Question>>
    init {
        val questionDao = QuestionDatabase.getDatabase(application).questionDao()
        questionRepo = QuestionRepository(questionDao)
        allQuestions = questionRepo.getAllQuestions
    }
    fun insertQuestion(question: Question) = viewModelScope.launch(Dispatchers.IO){
        questionRepo.addQuestion(question)
    }
}