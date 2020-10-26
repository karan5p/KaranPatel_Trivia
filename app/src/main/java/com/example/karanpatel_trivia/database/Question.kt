package com.example.karanpatel_trivia.database
//991519115 Karan Patel A2
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Question_table")
data class Question(
        var question: String,
        var optionA: String,
        var optionB: String,
        var optionC: String,
        var optionD: String,
        var correctAnswer: String,
        @PrimaryKey(autoGenerate = true)
        val id:Int
)
{
    constructor() : this(
            "",
            "",
            "",
            "",
            "",
            "",
            0
    )
}