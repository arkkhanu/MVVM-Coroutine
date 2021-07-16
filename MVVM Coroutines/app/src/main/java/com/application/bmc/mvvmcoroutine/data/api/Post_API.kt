package com.application.bmc.mvvmcoroutine.data.api

import androidx.lifecycle.LiveData
import com.application.bmc.mvvmcoroutine.data.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Post_API {


    @GET("/posts")
    suspend fun getSuspendedPost(): Response<List<Post>>

    companion object {
       private var retrofitService: Post_API? = null

    internal fun getInstance() : Post_API {
            if (retrofitService == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    retrofitService = retrofit.create(Post_API::class.java)
            }
            return retrofitService!!
        }
    }

}