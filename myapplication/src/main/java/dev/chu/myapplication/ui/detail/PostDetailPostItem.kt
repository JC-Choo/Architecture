package dev.chu.myapplication.ui.detail

import dev.chu.myapplication.data.entity.Post

class PostDetailPostItem(
    private val post: Post
) : PostDetailItem() {

    val title: String get() = post.title

    val body: String get() = post.body

    override fun getType(): Type {
        return Type.POST
    }
}