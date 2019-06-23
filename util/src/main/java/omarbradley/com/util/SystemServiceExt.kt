package omarbradley.com.util

import android.content.Context
import android.view.LayoutInflater

val Context.layoutInflaterService: LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
