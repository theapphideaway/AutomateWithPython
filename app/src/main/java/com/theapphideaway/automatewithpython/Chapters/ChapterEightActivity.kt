package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.chaquo.python.Python
import com.theapphideaway.automatewithpython.R
import kotlinx.android.synthetic.main.activity_chapter_eight.*
import java.io.*



class ChapterEightActivity : AppCompatActivity() {

    val filename = "FromPython.txt"
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
        // Get the directory for the user's public documents directory.
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!path.mkdirs()) {
            path.mkdirs()
        }
        return path
    }


    private fun getFilename(): File {
        fileToReadAndWrite = File(getDocumentStoragePath(), filename)
        return fileToReadAndWrite as File
    }

    private fun isFileWritable(file: File): Boolean {
        return if (!file.canWrite()) {
            file.setWritable(true)
        } else file.canWrite()
    }

    private fun readFile(textFile: File) = try {
        //val fis = FileInputStream(textFile)

       // var someText = PrintWriter(textFile)

        //val inputAsString = FileInputStream(textFile).bufferedReader().use { it.readText() }

        var text = textFile.readText()
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        //var results = pyClass.callAttr("read_file", fos, filesDir.toString(), filename).toString()

//        var myData = ""
//
//        val `in` = DataInputStream(fis)
//        val br = BufferedReader(InputStreamReader(`in`))
//        var strLine = br.readLine()
//        while (strLine != null) {
//            myData += strLine
//        }
//        `in`.close()
//
//        var foo = myData

        //Toast.makeText(this, results, Toast.LENGTH_SHORT).show()
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


            var results = pyClass.callAttr("write_to_file", fos, filesDir.toString(), filename).toString()


//            fos.write("Hey whats going on I just wrote this from the python app.".toByteArray())
//            fos.close()
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
