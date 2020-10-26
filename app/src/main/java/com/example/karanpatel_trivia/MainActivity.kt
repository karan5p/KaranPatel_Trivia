package com.example.karanpatel_trivia
//991519115 Karan Patel A2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.karanpatel_trivia.database.Question
import com.example.karanpatel_trivia.database.QuestionViewModel
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
    private fun getQuiz(){
        var viewModel = QuestionViewModel(this.application)
        viewModel.insertQuestion(Question("What does WWW stand for?","Wild Wacky Webalicious","Wild Wild Web","World Wide Web","World Water War","World Wide Web",0))
        viewModel.insertQuestion(Question("What is a portable + battery powered computer?","Trackbook","Desktop","Modem","Laptop","Laptop",0))
        viewModel.insertQuestion(Question("Wireless Internet is also called?","WiFi","WeFe","HiFi","HiFe","WiFi",0))
        viewModel.insertQuestion(Question("A small, portable electronic device used to perform calculations?","Computer","Cell Phone","IPad","Calculator","Calculator",0))
        viewModel.insertQuestion(Question("A panel designed to absorb the sun's rays as a source of energy for generating electricity?","Solar Panel","Lunar Panel","Water Panel","Wind Panel","Solar Panel",0))
        viewModel.insertQuestion(Question(".JPG' extension refers usually to what kind of file?","Music","Website","Image","Document","Image",0))
        viewModel.insertQuestion(Question("Firefox, Chrome, Safari and Explorer are types of what?","Video Games","Web Browsers","Cell Phones","Computer Brands","Web Browsers",0))
        viewModel.insertQuestion(Question("What is an unmanned aerial vehicle?","Robot","Drone","Techbot","Sky Flyer","Drone",0))
        viewModel.insertQuestion(Question("What company made electric cars popular?","Tesla","Audi","Honda","Ford","Tesla",0))
        viewModel.insertQuestion(Question("What year did the iPhone launch?","2007","2009","2006","2010","2007",0))
        val quizIntent = Intent(this,QuizActivity::class.java)
        startActivity(quizIntent)
    }

}