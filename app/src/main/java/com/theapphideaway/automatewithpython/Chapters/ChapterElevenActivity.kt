package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_eleven.*

class ChapterElevenActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterEleven")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_eleven)


        search_button.setOnClickListener {
            var requestResult = pyClass.callAttr("open_web", url_edit_text.text.toString())
            requests_text_view.text = requestResult.toString()

            var soupResult = pyClass.callAttr("scrape_element", url_edit_text.text.toString())
            p_elements_text_view.text = soupResult.toString()
        }




       // Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
    }
}
