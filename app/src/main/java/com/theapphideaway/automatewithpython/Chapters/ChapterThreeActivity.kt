package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_three.*

class ChapterThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_three)

        val py: Python = Python.getInstance()
        var pyClass = py.getModule("ChapterThree")

        exception_button.setOnClickListener {
            var exceptionText =pyClass.callAttr("exception_handling", exception_edit_text.text.toString().toInt())

            exception_text.text = exceptionText.toString()
        }
    }
}
