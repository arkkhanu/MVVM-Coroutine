package com.application.bmc.mvvmcoroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.application.bmc.mvvmcoroutine.data.repository.Post_Repository
import java.lang.IllegalArgumentException


/*
class PostViewModelFactory constructor(val respository : Post_Repository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return PostViewModel(respository) as T
        return if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            PostViewModel(respository) as T
        } else{
            throw  IllegalArgumentException("ViewModel Not Found")
        }
    }

}*/
