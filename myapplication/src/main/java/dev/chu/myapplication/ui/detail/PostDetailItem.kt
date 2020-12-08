package dev.chu.myapplication.ui.detail

// 공통 Base 아이템
abstract class PostDetailItem {
    abstract fun getType(): Type

    enum class Type {
        USER,   // 사용자 정보
        POST,   // 게시 글
        COMMENT // 댓글
    }
}