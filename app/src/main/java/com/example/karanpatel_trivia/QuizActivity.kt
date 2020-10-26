package com.example.karanpatel_trivia
//991519115 Karan Patel A2
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz.*
import com.example.karanpatel_trivia.database.Question
import com.example.karanpatel_trivia.database.QuestionViewModel

class QuizActivity : AppCompatActivity() {
    lateinit var viewModel: QuestionViewModel
    var count = 0
    var correctAnswer = 0
    val TAG: String = this@QuizActivity.toString()
    var arrayQ = mutableListOf<Question>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        viewModel = QuestionViewModel(this.application)
        this.getQuestions()
    }
    fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                btnNext.id -> {
                    if (validateAnswer()) {
                        if (count <= 10) {
                            count++
                            this.displayQuestion()
                        } else if (count > 10) {
                            val dBuilder = AlertDialog.Builder(this)
                            dBuilder.setTitle("Result")
                            dBuilder.setMessage("You Scored $correctAnswer out of 10.\nDo you want to try again?")
                            dBuilder.setPositiveButton("YES") { _: DialogInterface, _: Int ->
                                finish()
                                startActivity(intent)
                            }
                            dBuilder.setNegativeButton("CANCEL") { _: DialogInterface, _: Int ->
                            }
                            dBuilder.show()
                        }
                    }
                }
            }
        }
    }
    fun getQuestions() {
        viewModel.allQuestions.observe(this@QuizActivity, {
            for (question in it) {
                arrayQ.add(question)
                Log.d(TAG, question.toString())
            }
        })
    }
    fun validateAnswer(): Boolean {
        if (radioGroup.checkedRadioButtonId == -1) {
            val t = Toast.makeText(this@QuizActivity, "Please select at least one answer", Toast.LENGTH_SHORT)
            t.show()
            return false
        }
        return true
    }
    fun displayQuestion() {
        var userAnswer = ""
        tvQuestion.text = arrayQ[count].question
        radio1.text = arrayQ[count].optionA
        radio2.text = arrayQ[count].optionB
        radio3.text = arrayQ[count].optionC
        radio4.text = arrayQ[count].optionD
        when (radioGroup.checkedRadioButtonId) {
            R.id.radio1 -> userAnswer = arrayQ[count].optionA
            R.id.radio2 -> userAnswer = arrayQ[count].optionB
            R.id.radio3 -> userAnswer = arrayQ[count].optionC
            R.id.radio4 -> userAnswer = arrayQ[count].optionD
        }
        if (userAnswer == arrayQ[count].correctAnswer) {
            if (correctAnswer <= 10){
                correctAnswer++
            }
        }
    }
}
