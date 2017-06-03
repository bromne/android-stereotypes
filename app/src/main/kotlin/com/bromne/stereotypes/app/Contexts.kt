package com.bromne.stereotypes.app

import android.content.Context
import android.view.LayoutInflater

/**
 * get LayoutInflater from Context.
 */
@Suppress("unused")
val Context.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this)
