package dev.chu.myapplication.ui.post

import dev.chu.myapplication.data.entity.Post

// 도메인 레이어와 프레젠테이션 레이어 분리를 위해 정의한 클래스
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