package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_six.*

class ChapterSixActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_six)

        val py = Python.getInstance()
        var pyClass = py.getModule("ChapterSix")

        in_text_view.text = "Hello in Hello World: " + pyClass.callAttr("in_fun").toString()
        index_text_view.text = "letter at index 4: " + pyClass.callAttr("string_index").toString()
        upper_text_view.text = "Hello World to upper case: " + pyClass.callAttr("call_upper").toString()
        start_text_view.text = "Hello World starts with He: " + pyClass.callAttr("call_starts").toString()
        center_text_view.text = "Hello World in the center of = : " + '\n' + pyClass.callAttr("call_center").toString()

    }
}
