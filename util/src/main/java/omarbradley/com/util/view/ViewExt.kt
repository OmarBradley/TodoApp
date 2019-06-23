package omarbradley.com.util.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import omarbradley.com.util.R

fun Context.longToast(message: Int): Toast = Toast
    .makeText(this, message, Toast.LENGTH_SHORT)
    .apply {
        show()
    }

fun RecyclerView.addVerticalDecoration() =
    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        .apply {
            setDrawable(context.getDrawable(R.drawable.vertical_line_1dp)!!)
        })

fun LayoutInflater.inflateLayout(@LayoutRes layoutRes: Int, root: ViewGroup) : View =
    inflate(layoutRes, root, false)

