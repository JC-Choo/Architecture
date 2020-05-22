package dev.chu.myapplication.ui.post

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.chu.myapplication.BR
import dev.chu.myapplication.R
import dev.chu.myapplication.databinding.ViewPostBinding
import dev.chu.myapplication.util.ViewBindingHolder
import javax.inject.Inject

/**
 * 게시 글 목록을 위한 Adapter
 */
class PostAdapter @Inject constructor() : RecyclerView.Adapter<ViewBindingHolder<*>>() {

    // 뷰 홀더용 뷰 모델 리스트 변수
    private val items: MutableList<PostItem> = ArrayList()

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBindingHolder<*> {
        return ViewBindingHolder<ViewPostBinding>(parent.context, viewType)
    }

    override fun onBindViewHolder(holder: ViewBindingHolder<*>, position: Int) {
        holder.getBinding().setVariable(BR.item, items[position])
        holder.getBinding().executePendingBindings()
    }

    // 레이아웃 종류
    override fun getItemViewType(position: Int): Int {
        return R.layout.view_post
    }

    // 게시글 목록 수
    override fun getItemCount(): Int {
        return items.size
    }

    // 외부로부터 게시글 목록을 받아서 UI를 갱신한다.
    fun setItems(items: List<PostItem>?) {
        this.items.clear()
        this.items.addAll(items!!)
        notifyDataSetChanged()
    }
}