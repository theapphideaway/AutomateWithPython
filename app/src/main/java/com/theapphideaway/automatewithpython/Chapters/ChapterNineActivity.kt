package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_nine.*
import java.io.File

class ChapterNineActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterNine")
    var fileToReadAndWrite: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_nine)

        rename_button.setOnClickListener {
            var renameResult = pyClass.callAttr("rename_file", getOldFilename(), getNewFilename())
            Toast.makeText(this, renameResult.toString(), Toast.LENGTH_LONG).show()
        }

        delete_button.setOnClickListener {
            var deleteResult = pyClass.callAttr("delete_file", getNewFilename())
            Toast.makeText(this, deleteResult.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun getDocumentStoragePath(): File {
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }

    private fun getOldFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), "${old_file_edit_text.text}.txt")

        return fileToReadAndWrite as File
    }

    private fun getNewFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), "${new_name_edit_text.text}.txt")

        return fileToReadAndWrite as File
    }
}
