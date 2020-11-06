package ru.netology.androidbasic_2_1_1

data class Post (
    val id: Int,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean,
    var likes: Int,
    var shares: Int,
    var views: Int
)