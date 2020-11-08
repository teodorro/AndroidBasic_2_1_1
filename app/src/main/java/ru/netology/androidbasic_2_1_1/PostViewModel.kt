package ru.netology.androidbasic_2_1_1

import androidx.lifecycle.ViewModel

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()

    fun like() = repository.like()
    fun share() = repository.share()
}