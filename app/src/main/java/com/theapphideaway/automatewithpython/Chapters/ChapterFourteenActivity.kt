package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_fourteen.*

class ChapterFourteenActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterFourteen")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_fourteen)

        temp_button.setOnClickListener {

            weather_text_view.text = pyClass.callAttr("get_weather", location_edit_text.text.toString()).toString()

        }

    }
}
