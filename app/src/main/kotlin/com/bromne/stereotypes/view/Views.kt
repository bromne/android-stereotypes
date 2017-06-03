package com.bromne.stereotypes.view

import android.support.annotation.AnimRes
import android.view.View
import android.view.animation.AnimationUtils

@Suppress("unused")
fun View.startAnimation(@AnimRes resourceId: Int): Unit {
    val anim = AnimationUtils.loadAnimation(this.context, resourceId)
    this.startAnimation(anim)
}
