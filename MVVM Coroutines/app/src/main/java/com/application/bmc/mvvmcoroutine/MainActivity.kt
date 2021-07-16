package com.application.bmc.mvvmcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.bmc.mvvmcoroutine.data.features.post.PostRecyclerViewAdaptor
import com.application.bmc.mvvmcoroutine.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    lateinit var postViewModel: PostViewModel
    lateinit var recyclerView : RecyclerView
    lateinit var btn_click :Button
    lateinit var progress_circular :ProgressBar
    lateinit var adapter :PostRecyclerViewAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateIDs()

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        postViewModel.postList.observe(this, {
            if(it.isNotEmpty()){
                recyclerView.visibility = View.VISIBLE
                adapter.setPostList(it)
            }else{
                recyclerView.visibility = View.GONE
            }
        })

        postViewModel.loading.observe(this, {
           if(it){
               progress_circular.visibility = View.VISIBLE
           }else{
               progress_circular.visibility = View.GONE
           }

        })

        postViewModel.errorMessage.observe(this, {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        })


        btn_click.setOnClickListener {
            recyclerView.visibility = View.GONE
            postViewModel.getPostFromAPI()
        }

    }

    fun populateIDs(){
        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PostRecyclerViewAdaptor()
        recyclerView.adapter = adapter
        btn_click = findViewById(R.id.btn_click)
        progress_circular = findViewById(R.id.progress_circular)
    }


}