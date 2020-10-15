package com.example.helloworld

import CommentsAdapter
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.data.Comment
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var comments: ArrayList<Comment>

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        val rvContacts = findViewById<View>(R.id.list) as RecyclerView
        // Initialize contacts
        comments = Comment.createMessages(10)
        // Create adapter passing in the sample user data
        val adapter = CommentsAdapter(comments)
        // Attach the adapter to the recyclerview to populate items
        rvContacts.adapter = adapter
        // Set layout manager to position the items
        rvContacts.layoutManager = LinearLayoutManager(this)
        // That's all!

        val mView = findViewById<EditText>(R.id.EditComment)
        val mButton = findViewById<Button>(R.id.PostButton)
        val mLayout = findViewById<RelativeLayout>(R.id.FullLayout)

        mButton.setOnClickListener() {
            val inputValue: String = mView.text.toString()
            if (inputValue == null || inputValue.trim() == "") {
                Toast.makeText(
                    this,
                    "please input data, edit text cannot be blank",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                mView.setText("")
                comments.add(0, Comment("NewPerson", message = inputValue, votes = 0, level = 0))
                adapter.notifyItemChanged(0)
                rvContacts.smoothScrollToPosition(0);
                try {
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(mView.getWindowToken(), 0)
                }
                catch(ex : Exception){
                    // Do nothing
                }
            }
        }
    }
}