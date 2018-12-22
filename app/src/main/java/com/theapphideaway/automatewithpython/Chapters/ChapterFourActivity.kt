package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_four.*

class ChapterFourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_four)

        val py = Python.getInstance()
        var pyClass = py.getModule("ChapterFour")
        list_text_view.text = "My list: " + pyClass.callAttr("my_list").toString()

        index_button.setOnClickListener {
            item_at_index_text_view.text = "Item at index: " + pyClass.callAttr("item_at_index",
                delete_by_index_edit_text.text.toString().toInt())

            new_list_text_view.text = "After deleting item at your index: " + pyClass.callAttr("delete_at_index",
                delete_by_index_edit_text.text.toString().toInt())
        }

        verify_button.setOnClickListener {
            verify_text_view.text = "Is it in the list? " + pyClass.callAttr("is_in_list",
                verify_edit_text.text.toString())
            added_item_list_text_view.text = "New List: " + pyClass.callAttr("add_item", verify_edit_text.text.toString())
        }
    }
}
