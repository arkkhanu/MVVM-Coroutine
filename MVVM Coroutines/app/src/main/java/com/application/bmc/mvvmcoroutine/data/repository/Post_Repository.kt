package com.application.bmc.mvvmcoroutine.data.repository

import com.application.bmc.mvvmcoroutine.data.api.Post_API
import com.application.bmc.mvvmcoroutine.data.model.Post
import retrofit2.Response


class Post_Repository  : Methods{
    val retrofitService = Post_API.getInstance()
    override suspend fun getPostfromApi(): Response<List<Post>> {
       return retrofitService.getSuspendedPost()
    }
}

interface Methods{
    suspend fun getPostfromApi():Response<List<Post>>
}

