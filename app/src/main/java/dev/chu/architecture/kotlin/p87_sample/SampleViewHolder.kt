package dev.chu.architecture.kotlin.p87_sample

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.chu.architecture.R

class SampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val sampleIv: ImageView = view.findViewById(R.id.sample_iv)
    private val sampleTv: TextView = view.findViewById(R.id.sample_tv)

    fun bind(item: Sample) {
        sampleTv.text = item.str
    }
}