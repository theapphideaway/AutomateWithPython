package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_chapter_sixteen, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item != null){
            when(item.itemId){
                R.id.send_button_item ->{

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

        return super.onOptionsItemSelected(item)
    }
}
