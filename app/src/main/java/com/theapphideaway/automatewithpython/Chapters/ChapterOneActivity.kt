package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_one.*

class ChapterOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_one)

        val py: Python = Python.getInstance()
        var pyClass = py.getModule("ChapterOne")
        var pyInt = pyClass.callAttr("get_int")
        var pyFloat = pyClass.callAttr("get_float")
        var pyString = pyClass.callAttr("get_string")
        var pyConcat = pyClass.callAttr("get_concat")
        var pyNameQuestion = pyClass.callAttr("get_name_question")
        var pyAgeQuestion = pyClass.callAttr("get_age_question")



        py_int_text.setText("Integer from Python: " + pyInt)
        py_float_text.setText("Float from Python: " + pyFloat)
        py_string_text.setText("String from Python: " + pyString)
        py_string_concat_text.setText(pyConcat.toString())
        py_program_greeting_text.setText(pyString.toString())
        py_program_name_question_text.setText(pyNameQuestion.toString())

        py_name_button.setOnClickListener {
            var pyName = pyClass.callAttr("get_name", py_program_name_edit_text.text.toString())
            var pyNameLength = pyClass.callAttr("get_name_length", py_program_name_edit_text.text.toString())
            py_personal_greeting_text.setText(pyName.toString())
            py_name_length_text.setText(pyNameLength.toString())
        }

        py_program_age_question_text.setText(pyAgeQuestion.toString())

        py_age_button.setOnClickListener {
            var pyAge = pyClass.callAttr("get_age", py_program_age_edit_text.text.toString().toInt())
            py_age_calc_text.setText(pyAge.toString())
        }

    }
}
