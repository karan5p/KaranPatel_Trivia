package com.example.karanpatel_trivia

import androidx.room.Entity
import androidx.room.PrimaryKey

class Question {
    @Entity(tableName = "Questions_table")
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
}