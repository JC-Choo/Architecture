package dev.chu.architecture.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.chu.architecture.R
import dev.chu.architecture.model.GithubRepos

class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val ivAvatar: ImageView = view.findViewById(R.id.repo_iv)
    private val tvName: TextView = view.findViewById(R.id.repo_tv_name)
    private val tvLanguage: TextView = view.findViewById(R.id.repo_tv_language)
    private val tvTime: TextView = view.findViewById(R.id.repo_tv_time)

    fun bind(item: GithubRepos, callback:(GithubRepos) -> Unit) {
        Glide.with(itemView.context)
            .load(item.owner.avatarUrl)
            .into(ivAvatar)

        tvName.text = item.name
        tvLanguage.text = item.language
        tvTime.text = item.updatedAt.toString().split("GMT")[0]

        itemView.setOnClickListener { callback(item) }
    }
}