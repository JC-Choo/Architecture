package dev.chu.architecture.view

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dev.chu.architecture.databinding.ItemMainBinding
import dev.chu.architecture.model.GithubRepos

class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: ItemMainBinding = DataBindingUtil.bind(view)!!

    fun bind(item: GithubRepos, callback:(GithubRepos) -> Unit) {
        binding.apply {
            this.item = item
        }

        itemView.setOnClickListener { callback(item) }
    }
}