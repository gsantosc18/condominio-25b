package br.com.gedalias.appcondominio.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.widget.ProgressBar
import br.com.gedalias.appcondominio.R
import br.com.gedalias.appcondominio.animation.LoadAppProgressAnimation

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var progressBar: ProgressBar = findViewById(R.id.loadApp)
        var animation = getAnimation(progressBar)
        animation.duration = 2000
        progressBar.startAnimation(animation)
    }

    private fun getAnimation(progressBar: ProgressBar): LoadAppProgressAnimation {
        var animation = LoadAppProgressAnimation(progressBar, 1, 95)
        animation.setAnimationListener(PerformActionAnimation(this))
        return animation
    }
}

class PerformActionAnimation(
    private val context: Context
): Animation.AnimationListener {
    override fun onAnimationStart(p0: Animation?) {}

    override fun onAnimationEnd(p0: Animation?) {
        goToHome()
    }

    override fun onAnimationRepeat(p0: Animation?) {}


    private fun goToHome() {
        val homeIntent = Intent(context, HomeActivity::class.java)
        context.startActivity(homeIntent)
    }

}