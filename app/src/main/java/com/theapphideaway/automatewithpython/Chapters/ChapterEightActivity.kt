package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_eight.*
import java.io.*
import java.math.BigInteger
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest


class ChapterEightActivity : AppCompatActivity() {

    var fileToReadAndWrite: File? = null

    val py = Python.getInstance()
    var pyClass = py.getModule("ChapterEight")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_eight)

        button.setOnClickListener{

            if (isExternalStorageWritable()) {
                if (filesDir.exists()) {
                    if (isFileWritable(filesDir)) {
                        writeToFile(getFilename())

                    } else {
                        Toast.makeText(this, "Not Writable dir", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "No directory", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Storage not writable.", Toast.LENGTH_LONG).show()
            }
       }

        button_read.setOnClickListener {
            if (isExternalStorageWritable()) {
                if (filesDir.exists()) {
                    if (isFileWritable(filesDir)) {
                        readFile(getFilename())

                    } else {
                        Toast.makeText(this, "Not Writable dir", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "No directory", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Storage not writable.", Toast.LENGTH_LONG).show()
            }

        }
    }


    private fun isExternalStorageWritable(): Boolean {
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == state
    }


    private fun getDocumentStoragePath(): File {
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }


    private fun getFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), "${title_edit_text.text}.txt")

        return fileToReadAndWrite as File
    }

    private fun isFileWritable(file: File): Boolean {
        return if (!file.canWrite()) {
            file.setWritable(true)
        } else file.canWrite()
    }

    private fun readFile(textFile: File) = try {

        var results = pyClass.callAttr("read_file",textFile).toString()

        Toast.makeText(this, results, Toast.LENGTH_SHORT).show()

    } catch (e: FileNotFoundException) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
    } catch (e: IOException) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()

    } catch (e: Exception) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
    }

    private fun writeToFile(textFile: File) {
        try {
            val fos = FileOutputStream(textFile)


            var results = pyClass.callAttr("write_to_file", fos, content_edit_text.text.toString()).toString()

            Toast.makeText(this, results, Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()

        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }
    }

}
