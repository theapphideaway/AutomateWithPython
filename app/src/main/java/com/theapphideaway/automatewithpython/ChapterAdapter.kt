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
                holder.itemView.chapter.text.toString() == "Chapter 6" -> {
                    var intent = Intent(context, ChapterSixActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 7" -> {
                    var intent = Intent(context, ChapterSevenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 8" -> {
                    var intent = Intent(context, ChapterEightActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 9" -> {
                    var intent = Intent(context, ChapterNineActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 10" -> {
                    var intent = Intent(context, ChapterTenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 11" -> {
                    var intent = Intent(context, ChapterElevenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 12" -> {
                    var intent = Intent(context, ChapterTwelveActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 13" -> {
                    var intent = Intent(context, ChapterThirteenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 14" -> {
                    var intent = Intent(context, ChapterFourteenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 15" -> {
                    var intent = Intent(context, ChapterFifteenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 16" -> {
                    var intent = Intent(context, ChapterSixteenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 17" -> {
                    var intent = Intent(context, ChapterSeventeenActivity::class.java)
                    startActivity(context,intent, null)
                }
                holder.itemView.chapter.text.toString() == "Chapter 18" -> {
                    var intent = Intent(context, ChapterEighteenActivity::class.java)
                    startActivity(context,intent, null)
                }
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindPerson(chapter: Chapter) {
            var chapterText: TextView = itemView.findViewById(R.id.chapter) as TextView
            var descriptionText: TextView = itemView.findViewById(R.id.description) as TextView

            chapterText.text = chapter.Title
            descriptionText.text = chapter.Description
        }
    }
}