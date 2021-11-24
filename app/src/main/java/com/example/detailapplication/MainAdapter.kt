package com.example.detailapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PointF
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.internal.Utils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.RequestOptions.overrideOf


/**
 * Created by Wasabeef on 2015/01/11.
 */
class MainAdapter(
  private val context: Context,
  private val dataSet: MutableList<Type>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

  enum class Type {
    Mask,
    NinePatchMask,
    CropTop,
    CropCenter,
    CropBottom,
    CropSquare,
    CropCircle,
    CropCircleWithBorder,
    ColorFilter,
    Grayscale,
    RoundedCorners,
    BlurLight,
    BlurDeep,
    Toon,
    Sepia,
    Contrast,
    Invert,
    Pixel,
    Sketch,
    Swirl,
    Brightness,
    Kuawahara,
    Vignette
  }

  override fun getItemCount(): Int {
    return dataSet.size
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false)
    return ViewHolder(v)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    when (dataSet[position]) {
      Type.Mask -> {
        Glide.with(context)
          .load(R.drawable.check)
          .apply(overrideOf(266, 252))
          .apply(bitmapTransform(MultiTransformation<Bitmap>(CenterCrop())))
          .into(holder.image)
      }
      Type.NinePatchMask -> {
        Glide.with(context)
          .load(R.drawable.check)
          .apply(overrideOf(300, 200))
          .apply(bitmapTransform(MultiTransformation<Bitmap>(CenterCrop())))
          .into(holder.image)
      }

      Type.CropTop -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.CropCenter -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.CropBottom -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.CropSquare -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.CropCircle -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.CropCircleWithBorder -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.ColorFilter -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.Grayscale -> Glide.with(context)
        .load(R.drawable.demo)

      Type.BlurLight -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.BlurDeep -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Toon -> Glide.with(context)
        .load(R.drawable.demo)
        .into(holder.image)

      Type.Sepia -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Contrast -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Invert -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Pixel -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Sketch -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Swirl -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Brightness -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Kuawahara -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)

      Type.Vignette -> Glide.with(context)
        .load(R.drawable.check)
        .into(holder.image)
    }
    holder.title.text = dataSet[position].name
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image: ImageView = itemView.findViewById(R.id.image)
    var title: TextView = itemView.findViewById(R.id.title)
  }

}
