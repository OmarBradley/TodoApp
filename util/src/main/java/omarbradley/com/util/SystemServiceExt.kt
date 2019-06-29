package omarbradley.com.util

import android.content.Context
import android.view.LayoutInflater

val Context.layoutInflaterService: LayoutInflater
    get() = LayoutInflater.from(this)
