package dev.chu.myapplication.ui.post

import dev.chu.myapplication.data.entity.Post

class PostItem constructor(
    private val post: Post,
    @JvmField private val eventListener: EventListener
) {
    fun getPost(): Post = post

    fun getTitle(): String = post.title

    fun getEventListener(): EventListener = eventListener

    interface EventListener {
        fun onPostClick(postItem: PostItem)
    }
}