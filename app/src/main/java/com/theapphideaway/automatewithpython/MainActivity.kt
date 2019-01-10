package com.theapphideaway.automatewithpython

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.support.v7.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private var chapterAdapter: ChapterAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var chapterList: ArrayList<Chapter>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val PERMISSION_REQUEST_CODE = 1
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permissions, PERMISSION_REQUEST_CODE)
            }
        }

        chapterList = ArrayList()
        layoutManager = LinearLayoutManager(this)
        chapterAdapter = ChapterAdapter(chapterList!!, this)

        chapter_recycler_view.adapter = chapterAdapter
        chapter_recycler_view.layoutManager = layoutManager

        for (i in 1..18)
        {
            val chapter = Chapter()
            chapter.Title = "Chapter $i"

            when (i)
            {
                1 -> chapter.Description = "Python Basics"
                2 -> chapter.Description = "Flow Control"
                3 -> chapter.Description = "Functions"
                4 -> chapter.Description = "Lists"
                5 -> chapter.Description = "Dictionaries and Structuring Data"
                6 -> chapter.Description = "Manipulating Strings"
                7 -> chapter.Description = "Pattern Matching with Regular Expressions"
                8 -> chapter.Description = "Reading and Writing Files"
                9 -> chapter.Description = "Organizing Files"
                10 -> chapter.Description = "Debugging"
                11 -> chapter.Description = "Web Scraping"
                12 -> chapter.Description = "Working with Excel Spreadsheets"
                13 -> chapter.Description = "Working with PDF and Word Documents"
                14 -> chapter.Description = "Working with CSV and JSON Files"
                15 -> chapter.Description = "Keeping Time, Scheduling Tasks, and Launching Programs"
                16 -> chapter.Description = "Sending Email and Text Messages"
                17 -> chapter.Description = "Manipulating Images"
                18 -> chapter.Description = "Controlling the Keyboard and Mouse with GUI Automation"
            }
            chapterList!!.add(chapter)
        }
        chapterAdapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item != null){
            when(item.itemId){
                R.id.info_button_item ->{

                    val alertDialog = AlertDialog.Builder(this)

                    // Setting Dialog Title
                    alertDialog.setTitle("WELCOME!")

                    // Setting Dialog Message
                    alertDialog.setMessage("This app is based entirely off of the book \"Automate the Boring Stuff With Python\". " +
                            "Download the support files at " +
                            "https://nostarch.com/download/Automate_the_Boring_Stuff_onlinematerials_v.2.zip" +
                            ". Place each file in the Documents folder of your device for the implementations to work.")

                    alertDialog.setPositiveButton("OK") { _, _ ->}
                    val dialog: AlertDialog = alertDialog.create()
                    dialog.show()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
