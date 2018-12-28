package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_five.*
import kotlinx.android.synthetic.main.activity_chapter_seven.*

class ChapterSevenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_seven)

        val py = Python.getInstance()
        var pyClass = py.getModule("ChapterSeven")

        search_button.setOnClickListener {

            search_results_text_view.text = pyClass.callAttr("phone_search", base_text_view.text.toString()).toString()
            //Log.e("results displayed", "results displayed")
        }

        //result_text_view.text = pyClass.callAttr("email_search", base_edit_text.text.toString()).toString()
    }
}
