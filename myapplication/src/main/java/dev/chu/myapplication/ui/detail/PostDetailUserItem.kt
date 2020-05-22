package dev.chu.myapplication.ui.detail

import dev.chu.myapplication.data.entity.User

class PostDetailUserItem (
    val user: User,
    @JvmField val eventListener: EventListener
) : PostDetailItem() {

    fun getName() = user.name

    fun getUserId() = user.id

    fun getEventListener() = eventListener

    override fun getType(): Type {
        return Type.USER
    }

    interface EventListener {
        fun onUserClick(userId: Long)
    }
}