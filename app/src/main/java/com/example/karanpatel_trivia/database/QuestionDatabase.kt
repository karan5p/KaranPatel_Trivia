package com.example.karanpatel_trivia.database
//991519115 Karan Patel A2
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Question::class),version = 2)
abstract class QuestionDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    companion object {
        @Volatile
        private var INSTANCE: QuestionDatabase? = null
        fun getDatabase(context: Context): QuestionDatabase {
            val tempInstance = INSTANCE
            //if there is already some instance of the database, return that
            if (tempInstance != null) {
                return tempInstance
            }
            //otherwise, create new database
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,QuestionDatabase::class.java,"question_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}