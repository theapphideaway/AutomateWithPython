package com.theapphideaway.automatewithpython

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chapter_card.*
import java.io.File.separator
import android.os.Environment.getExternalStorageDirectory
import android.util.Log
import com.chaquo.python.Python
import java.io.File


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
            chapterList!!.add(chapter)
        }
        chapterAdapter!!.notifyDataSetChanged()
    }
}
