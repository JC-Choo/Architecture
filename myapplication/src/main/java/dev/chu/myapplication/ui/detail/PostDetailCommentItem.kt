package dev.chu.myapplication.ui.detail

import dev.chu.myapplication.data.entity.Comment

class PostDetailCommentItem(
    private val comment: Comment
) : PostDetailItem() {

    val name: String get() = comment.name

    val body: String get() = comment.body

    override fun getType(): Type {
        return Type.COMMENT
    }
}