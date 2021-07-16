package com.application.bmc.mvvmcoroutine.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.bmc.mvvmcoroutine.data.model.Post
import com.application.bmc.mvvmcoroutine.data.repository.Post_Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel : ViewModel() {
    val repository = Post_Repository()
    val postList = MutableLiveData<List<Post>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
//    var job:Job? = null

    fun getPostFromAPI() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getPostfromApi()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        postList.postValue(response.body())
                         loading.value = false
                    }
                    else {
                        loading.value = false
                        errorMessage.value = "False"
                    }
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    loading.value = false
                    errorMessage.value = e.message
                }
            }


        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "Destroy")
//        job?.cancel()
    }

}
