package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_thirteen.*
import java.io.File

class ChapterThirteenActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterThirteen")
    var fileToReadAndWrite: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_thirteen)

        save_button.setOnClickListener {
            var result = pyClass.callAttr("create_word_file", getFilename(title_edit_text.text.toString()).toString()).toString()

            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }
    }

    private fun getDocumentStoragePath(): File {
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }

    private fun getFilename(filename: String): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), filename + ".pdf")

        return fileToReadAndWrite as File
    }
}
