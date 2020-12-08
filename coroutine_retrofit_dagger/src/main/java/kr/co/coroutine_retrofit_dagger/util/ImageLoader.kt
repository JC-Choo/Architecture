package kr.co.coroutine_retrofit_dagger.util

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import java.io.File

object ImageLoader {

    fun loadImage(context: Context, url: String, imageView: ImageView, radius: Int = 1) {
        Glide.with(context)
            .load(url)
            .fitCenter()
            .transition(DrawableTransitionOptions.withCrossFade())
            .transform(MultiTransformation(CenterCrop(), RoundedCorners(radius)))
            .into(imageView)
    }

    fun loadImage(context: Context, file: File, imageView: ImageView, radius: Int = 1) {
        Glide.with(context)
            .load(file)
            .transition(DrawableTransitionOptions.withCrossFade())
            .transform(MultiTransformation(CenterCrop(), RoundedCorners(radius)))
            .into(imageView)
    }

    fun loadImage(context: Context, uri: Uri, imageView: ImageView, radius: Int = 1) {
        Glide.with(context)
            .load(uri)
            .transition(DrawableTransitionOptions.withCrossFade())
            .transform(MultiTransformation(CenterCrop(), RoundedCorners(radius)))
            .into(imageView)
    }

    fun loadImage(context: Context, resId: Int, imageView: ImageView, radius: Int = 1) {
        Glide.with(context)
            .load(resId)
            .transition(DrawableTransitionOptions.withCrossFade())
            .transform(MultiTransformation(CenterCrop(), RoundedCorners(radius)))
            .into(imageView)
    }

    fun loadImageWithoutTransform(context: Context, uri: Uri, imageView: ImageView) {
        Glide.with(context)
            .load(uri)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }

    fun loadImageWithCircularCrop(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }

    fun removeCache(context: Context) {
        Glide.get(context).clearMemory()
    }
}