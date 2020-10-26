package com.example.karanpatel_trivia.database
//991519115 Karan Patel A2
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestion(question: Question)
    @Query("SELECT * FROM Question_table")
    fun getAllQuestions(): LiveData<Array<Question>>
}
