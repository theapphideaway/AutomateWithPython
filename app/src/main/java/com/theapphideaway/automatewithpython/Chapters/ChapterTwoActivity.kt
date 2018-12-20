package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_two.*

class ChapterTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_two)

        val py: Python = Python.getInstance()
        val pyClass = py.getModule("ChapterTwo")

        age_button.setOnClickListener {
            var ageText = pyClass.callAttr("get_age", age_edit_text.text.toString().toInt())

            age_text_view.text = ageText.toString()
        }

        name_button.setOnClickListener {
            var whileLoopText = pyClass.callAttr("print_name", name_edit_text.text.toString(), age_edit_text.text.toString().toInt())
            var forLoopText = pyClass.callAttr("print_name_for", name_edit_text.text.toString(), age_edit_text.text.toString().toInt())

            for_loop_text.text = forLoopText.toString()
            while_loop_text.text = whileLoopText.toString()
        }


    }
}
