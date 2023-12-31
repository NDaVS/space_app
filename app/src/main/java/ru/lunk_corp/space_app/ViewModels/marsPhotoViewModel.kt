package ru.lunk_corp.space_app.ViewModels

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.squareup.picasso.Picasso

class marsPhotoViewModel(private val context: Application) : AndroidViewModel(context) {
    fun getMarsPhoto(imageView: ImageView, url: String) {
        Picasso.get().load(url).into(imageView)
//        Glide.with(context)
//            .asBitmap()
//            .load(url)
//            .into(object : CustomTarget<Bitmap>() {
//                override fun onResourceReady(
//                    resource: Bitmap,
//                    transition: Transition<in Bitmap>?
//                ) {
//                    imageView.setImageBitmap(resource)
//                }
//
//                override fun onLoadCleared(placeholder: Drawable?) {
//
//                }
//            })
    }
}