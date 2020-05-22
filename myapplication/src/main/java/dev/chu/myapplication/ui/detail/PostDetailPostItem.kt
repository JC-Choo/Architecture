package dev.chu.myapplication.ui.detail

import dev.chu.myapplication.data.entity.Post

class PostDetailPostItem(
    private val post: Post
) : PostDetailItem() {

    fun getTitle() = post.title

    fun getBody() = post.body

    override fun getType(): Type {
        return Type.POST
    }
}