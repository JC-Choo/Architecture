package kr.co.coroutine_retrofit_dagger.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_doggo.view.*
import kr.co.coroutine_retrofit_dagger.data.entity.Dog
import kr.co.coroutine_retrofit_dagger.util.ImageLoader

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(dog: Dog) {
        itemView.breed_name.text = dog.breed?.capitalize()
        dog.imageUrl?.let { it1 -> ImageLoader.loadImageWithCircularCrop(itemView.context, it1, itemView.episode_item_image) }
    }
}