package com.application.bmc.mvvmcoroutine.data.features.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.bmc.mvvmcoroutine.R
import com.application.bmc.mvvmcoroutine.data.model.Post

class PostRecyclerViewAdaptor :RecyclerView.Adapter<PostRecyclerViewAdaptor.PostViewHolder>() {

   private var postList  =mutableListOf<Post>()

    fun setPostList(postList : List<Post>){
        this.postList = postList.toMutableList()
        notifyDataSetChanged()
    }

    inner class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        val userId:TextView = view.findViewById(R.id.userId)
        val id:TextView = view.findViewById(R.id.id)
        val title:TextView = view.findViewById(R.id.title)
        val body:TextView = view.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewlist,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.id.text = post.id
        holder.userId.text = post.userId
        holder.title.text = post.title
        holder.body.text = post.body
    }

    override fun getItemCount() : Int = postList.size

}