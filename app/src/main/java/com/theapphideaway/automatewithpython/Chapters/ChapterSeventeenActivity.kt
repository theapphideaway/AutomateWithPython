package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_seventeen.*
import java.io.File

class ChapterSeventeenActivity : AppCompatActivity() {

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterSeventeen")
    var fileToRead: File? = null
    var logoToRead: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_seventeen)

        add_logo_button.setOnClickListener {
            var file = file_edit_text.text.toString()
            var logo = logo_edit_text.text.toString()

            var result = pyClass.callAttr("add_logo", getFilename(file).toString(),
                getLogoName(logo).toString()).toString()

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
        fileToRead = File(getDocumentStoragePath(), filename + ".png")
        return fileToRead as File
    }

    private fun getLogoName(logoName: String): File {
        logoToRead = File(getDocumentStoragePath(), logoName + ".png")
        return logoToRead as File
    }
}
