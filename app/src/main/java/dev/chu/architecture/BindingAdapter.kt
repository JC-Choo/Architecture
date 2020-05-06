package dev.chu.architecture

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import dev.chu.architecture.model.GithubRepos
import dev.chu.architecture.view.MainAdapter

@BindingAdapter("data")
fun RecyclerView.setItems(
    data: List<GithubRepos>?
) {
    (adapter as? MainAdapter)?.apply {
        if (data != null)
            setNewItems(data)
    } ?: run {
        adapter = MainAdapter { repo ->
            val text = "${repo.id} - ${repo.name} - ${repo.language}"
            Toast.makeText(this.context, text, Toast.LENGTH_SHORT).show()
        }
    }
}

@BindingAdapter("isVisibility")
fun ProgressBar.setVisibility(isVisibility: Boolean) {
    this.visibility = if(isVisibility) View.VISIBLE else View.GONE
}

@BindingAdapter("srcGlide")
fun ImageView.setGlide(url: String) {
    Glide.with(context)
        .load(url)
        .apply(
            RequestOptions()
                .transform(CenterCrop(), CircleCrop())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        )
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}