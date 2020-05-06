package dev.chu.architecture.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.chu.architecture.R
import dev.chu.architecture.model.GithubRepos
import dev.chu.architecture.view.MainViewHolder

class MainAdapter(private val callback:(GithubRepos) -> Unit): RecyclerView.Adapter<MainViewHolder>() {

    private val items: MutableList<GithubRepos> = mutableListOf()

    fun setNewItems(newItems: List<GithubRepos>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position], callback)
    }

}