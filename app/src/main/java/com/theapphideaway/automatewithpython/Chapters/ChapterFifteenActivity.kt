package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_fifteen.*

class ChapterFifteenActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterFifteen")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_fifteen)

        timer_button.setOnClickListener {

            var result = pyClass.callAttr("timer", timer_edit_text.text.toString()).toString()

            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }
    }
}
