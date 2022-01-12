package br.com.gedalias.appcondominio.animation

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar

class LoadAppProgressAnimation(
    private val loadAppProgressBar: ProgressBar,
    private val from: Int,
    private val to: Int
): Animation() {
    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        val value = from + (to - from) * interpolatedTime
        loadAppProgressBar.progress = value.toInt()
    }
}