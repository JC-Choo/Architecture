package dev.chu.myapplication.ui.detail

import dev.chu.myapplication.data.entity.Comment

class PostDetailCommentItem(
    private val comment: Comment
) : PostDetailItem() {

    fun getName() = comment.name

    fun getBody() = comment.body

    override fun getType(): Type {
        return Type.COMMENT
    }
}