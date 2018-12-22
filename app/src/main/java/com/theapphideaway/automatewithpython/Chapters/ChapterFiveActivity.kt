package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_five.*

class ChapterFiveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_five)

        val py = Python.getInstance()
        val pyClass = py.getModule("ChapterFive")

        dictionary_text_view.text = "Birthday dictionary: " + pyClass.callAttr("my_dictionary")

        name_button.setOnClickListener {
            result_text_view.text = pyClass.callAttr("get_birthdays", name_edit_text.text.toString()).toString()

            no_button.visibility = View.GONE
            yes_button.visibility = View.GONE
            enter_new_name_text_view.visibility = View.GONE
            birthday_edit_text.visibility = View.GONE
            birthday_button.visibility = View.GONE
            new_dictionary_text_view.visibility = View.GONE

            if(result_text_view.text == "Birthday information not found. Would you like to add it?")
            {
                no_button.visibility = View.VISIBLE
                yes_button.visibility = View.VISIBLE
            }

            enter_new_name_text_view.visibility = View.GONE
            birthday_edit_text.visibility = View.GONE
            birthday_button.visibility = View.GONE

        }

        yes_button.setOnClickListener {
            birthday_edit_text.visibility = View.VISIBLE
            birthday_button.visibility = View.VISIBLE
        }

        no_button.setOnClickListener {
            enter_new_name_text_view.visibility = View.VISIBLE
        }

        birthday_button.setOnClickListener {
            new_dictionary_text_view.visibility = View.VISIBLE
            new_dictionary_text_view.text = "Updated dictionary: " + pyClass.callAttr("add_birthday", name_edit_text.text.toString(),
                birthday_edit_text.text.toString())
        }


    }
}
