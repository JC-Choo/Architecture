package dev.chu.myapplication.ui.post

import dev.chu.myapplication.data.entity.Post

class PostItem(
    val post: Post,
    val eventListener: EventListener
) {

    val title: String
        get() = post.title

    interface EventListener {
        fun onPostClick(postItem: PostItem)
    }
}