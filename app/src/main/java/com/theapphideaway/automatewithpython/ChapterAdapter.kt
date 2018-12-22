package com.theapphideaway.automatewithpython

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.theapphideaway.automatewithpython.Chapters.*
import kotlinx.android.synthetic.main.chapter_card.view.*

class ChapterAdapter(private val chapterList: ArrayList<Chapter>, private val context: Context):
    RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.chapter_card, viewGroup, false)


        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return chapterList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPerson(chapterList[position])
        holder.itemView.setOnClickListener {

            when {
                holder.itemView.chapter.text.toString() == "Chapter 1" -> {
                    var intent = Intent(context, ChapterOneActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 2" -> {
                    var intent = Intent(context, ChapterTwoActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 3" -> {
                    var intent = Intent(context, ChapterThreeActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 4" -> {
                    var intent = Intent(context, ChapterFourActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 5" -> {
                    var intent = Intent(context, ChapterFiveActivity::class.java)
                    startActivity(context,intent, null)
                }
            }

        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPerson(chapter: Chapter) {
            var nameText: TextView = itemView.findViewById(R.id.chapter) as TextView

            nameText.text = chapter.Title
        }

    }
}