package com.theapphideaway.automatewithpython

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chapter_card.*

class MainActivity : AppCompatActivity() {

    private var chapterAdapter: ChapterAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var chapterList: ArrayList<Chapter>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
