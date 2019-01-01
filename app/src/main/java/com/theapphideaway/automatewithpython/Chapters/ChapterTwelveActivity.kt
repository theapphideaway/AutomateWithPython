package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_nine.*
import kotlinx.android.synthetic.main.activity_chapter_twelve.*
import java.io.File

class ChapterTwelveActivity : AppCompatActivity() {

    val py: Python = Python.getInstance()
    var pyClass = py.getModule("ChapterTwelve")
    var fileToReadAndWrite: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_twelve)

        original_sheet_text_view.text =  pyClass.callAttr("get_spreadsheet", getFilename().toString()).toString()
    }

    private fun getDocumentStoragePath(): File {
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }

    private fun getFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), "example.xlsx")

        return fileToReadAndWrite as File
    }

}
