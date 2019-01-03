package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_sixteen.*

class ChapterSixteenActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterSixteen")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_sixteen)

        send_button.setOnClickListener {

            var username = username_edit_text.text.toString()
            var password = password_edit_text.text.toString()
            var recipient = recipient_edit_text.text.toString()
            var subject = subject_edit_text.text.toString()
            var body = body_edit_text.text.toString()

            var result = pyClass.callAttr("send_email", username, password,recipient,subject,body).toString()

            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }
    }
}
