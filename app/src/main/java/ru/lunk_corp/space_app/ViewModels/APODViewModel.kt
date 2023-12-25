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


class APODViewModel(private val context: Application) : AndroidViewModel(context) {

    fun getAPODImage(imageView: ImageView, url: String){
        Picasso.get().load(url).into(imageView)
    }
}