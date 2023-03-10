package app.vazovsky.kinopoiskdev.extensions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

/**
 * Модифицированная версия функции для загрузки картинки с помощью Glide
 * Позволяет задавать трансформации, ресурсы для плейсхолдера или ошибки и другие параметры
 */
fun ImageView.load(
    imageUrl: String?,
    @DrawableRes placeHolderRes: Int? = null,
    @DrawableRes errorRes: Int? = placeHolderRes,
    @DrawableRes fallbackRes: Int? = placeHolderRes,
    isCircle: Boolean = false,
    transformations: List<Transformation<Bitmap>> = emptyList(),
    doOnFailure: () -> Unit = {},
    doOnSuccess: (Drawable?) -> Unit = { }
) {
    Glide.with(this).clear(this)
    Glide.with(context).load(imageUrl).apply { placeHolderRes?.let(::placeholder) }.apply { errorRes?.let(::error) }
        .apply { fallbackRes?.let(::fallback) }.apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)).apply {
            if (isCircle) {
                apply(RequestOptions.circleCropTransform())
            }
        }.addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean
            ): Boolean {
                e?.printStackTrace()
                doOnFailure.invoke()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean
            ): Boolean {
                doOnSuccess.invoke(resource)
                return false
            }
        }).apply { transform(*transformations.toTypedArray()) }.into(this)
}