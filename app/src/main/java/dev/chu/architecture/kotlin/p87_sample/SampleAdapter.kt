package dev.chu.architecture.kotlin.p87_sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.chu.architecture.R

class SampleAdapter(private val list: MutableList<Sample>) : RecyclerView.Adapter<SampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sample, parent, false)
        return SampleViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(list[position])
    }

}