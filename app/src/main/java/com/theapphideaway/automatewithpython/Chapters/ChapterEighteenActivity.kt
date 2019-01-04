package com.theapphideaway.automatewithpython.Chapters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.theapphideaway.automatewithpython.R
import android.view.MotionEvent

class ChapterEighteenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_eighteen)
    }

    //Unfortunately I was not able to get the module pyautogui to work, therefore I
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> Toast.makeText(this,"$x $y", Toast.LENGTH_SHORT).show()
            MotionEvent.ACTION_MOVE -> Toast.makeText(this,"$x $y", Toast.LENGTH_SHORT).show()
            MotionEvent.ACTION_UP ->Toast.makeText(this,"$x $y", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    fun makeToast(){

    }
}
