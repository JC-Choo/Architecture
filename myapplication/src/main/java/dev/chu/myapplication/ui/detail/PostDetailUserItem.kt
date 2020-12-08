package dev.chu.myapplication.ui.detail

import dev.chu.myapplication.data.entity.User

class PostDetailUserItem (
    val user: User,
    val eventListener: EventListener
) : PostDetailItem() {

    val name: String
        get() = user.name

    val userId: Long
        get() = user.id

    override fun getType(): Type {
        return Type.USER
    }

    interface EventListener {
        fun onUserClick(userId: Long)
    }
}