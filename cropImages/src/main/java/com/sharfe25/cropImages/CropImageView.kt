package com.sharfe25.cropImages

import android.content.Context
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * ImageView to show a image for cropping.
 */
class CropImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

  private var frame: RectF? = null

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    val height = measuredHeight.toFloat()
    val width = measuredWidth.toFloat()
    val frameRect = this.frame

    var scale : Float
    if (height > width) {
      scale = if (frameRect != null) frameRect.height() / height else 1f
    }else{
      scale = if (frameRect != null) frameRect.width() / width else 1f
    }

    setMeasuredDimension((width * scale).toInt(), (height * scale).toInt())

  }

  fun setFrame(frame: RectF) {
    this.frame = frame
  }
}
