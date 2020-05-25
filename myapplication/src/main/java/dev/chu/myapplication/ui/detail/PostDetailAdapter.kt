package dev.chu.myapplication.ui.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.chu.myapplication.BR
import dev.chu.myapplication.R
import dev.chu.myapplication.databinding.ViewPostDetailCommentBinding
import dev.chu.myapplication.databinding.ViewPostDetailPostBinding
import dev.chu.myapplication.databinding.ViewPostDetailUserBinding
import dev.chu.myapplication.util.ViewBindingHolder
import javax.inject.Inject

class PostDetailAdapter @Inject constructor() : RecyclerView.Adapter<ViewBindingHolder<*>>() {

    private val items: MutableList<PostDetailItem> = ArrayList()

    fun setNewItems(items: List<PostDetailItem>) {
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (PostDetailItem.Type.values()[items[position].getType().ordinal]) {
            PostDetailItem.Type.USER -> R.layout.view_post_detail_user
            PostDetailItem.Type.POST -> R.layout.view_post_detail_post
            PostDetailItem.Type.COMMENT -> R.layout.view_post_detail_comment
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingHolder<*> {
//        return ViewBindingHolder<>(parent.context, viewType)
        return when(viewType) {
            PostDetailItem.Type.USER.ordinal -> ViewBindingHolder<ViewPostDetailUserBinding>(parent.context, viewType)
            PostDetailItem.Type.POST.ordinal -> ViewBindingHolder<ViewPostDetailPostBinding>(parent.context, viewType)
            PostDetailItem.Type.COMMENT.ordinal -> ViewBindingHolder<ViewPostDetailCommentBinding>(parent.context, viewType)
            else -> ViewBindingHolder<ViewPostDetailUserBinding>(parent.context, viewType)
        }
    }

    override fun onBindViewHolder(holder: ViewBindingHolder<*>, position: Int) {
        holder.getBinding().setVariable(BR.item, items[position])
        holder.getBinding().executePendingBindings()
    }

}