package com.sharfe25.cropImages

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet

/**
 * Rectangle Overlay.
 *
 * This overlay creates a rectangle frame and draw borders if necessary.
 */
class RectangleCropOverlay @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    cropOverlayAttrs: AttributeSet? = attrs
) : CropOverlay(context, attrs, defStyleAttr, cropOverlayAttrs) {

  override fun drawCrop(canvas: Canvas, paint: Paint) {
    val frameRect = frame ?: return
    val frameWidth = frameRect.width()
    val frameHeight = frameRect.height()

    val left = (width - frameWidth) / 2f
    val top = (height - frameHeight) / 2f
    val right = (width + frameWidth) / 2f
    val bottom = (height + frameHeight) / 2f

    canvas.drawRect(left, top, right, bottom, paint)
  }

  override fun drawBorder(canvas: Canvas, paint: Paint) {
    val frameRect = frame ?: return
    val frameWidth = frameRect.width()
    val frameHeight = frameRect.height()

    val left = (width - frameWidth) / 2f
    val top = (height - frameHeight) / 2f
    val right = (width + frameWidth) / 2f
    val bottom = (height + frameHeight) / 2f

    canvas.drawLine(left, top, right, top, paint)
    canvas.drawLine(left, bottom, right, bottom, paint)

    canvas.drawLine(left, top, left, bottom, paint)
    canvas.drawLine(right, top, right, bottom, paint)
  }
}