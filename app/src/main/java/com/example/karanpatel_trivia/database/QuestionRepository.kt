package com.example.karanpatel_trivia.database
//991519115 Karan Patel A2
import androidx.lifecycle.LiveData
import com.example.karanpatel_trivia.database.Question

class QuestionRepository(private val questionDao: QuestionDao) {
    val getAllQuestions: LiveData<Array<Question>> = questionDao.getAllQuestions()
    suspend fun addQuestion(question: Question){
        questionDao.insertQuestion(question)
    }
}