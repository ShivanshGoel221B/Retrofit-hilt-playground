package com.shivansh.retrofitplayground.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shivansh.retrofitplayground.data.entity.PostEntity
import com.shivansh.retrofitplayground.data.repository.PostRepository
import com.shivansh.retrofitplayground.domain.repository.PostRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PostRepository
): ViewModel() {

    private val _posts = MutableStateFlow<List<PostEntity>>(emptyList())
    val posts = _posts.asStateFlow()

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            _posts.update { repository.getAllPosts() }
        }
    }



//    class MainViewModelFactory: ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return MainViewModel(repository = PostRepositoryImpl()) as T
//        }
//    }
}