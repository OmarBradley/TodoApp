package omarbradley.com.util.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.view_icon_bottom_text.view.*
import omarbradley.com.util.R
import omarbradley.com.util.layoutInflaterService


class IconBottomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    init {
        val layoutInflater = context.layoutInflaterService
        val view = layoutInflater.inflateLayout(R.layout.view_icon_bottom_text, this)
        addView(view)
        attrs?.let { getAttrs(attrs, defStyle) }
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int = 0) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconBottomTextView, defStyle, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray) {
        val backgroundColorRes =
            typedArray.getResourceId(R.styleable.IconBottomTextView_backgroundColor, R.color.bgWhite)
        frameLayout_background.setBackgroundResource(backgroundColorRes)

        val textRes = typedArray.getResourceId(R.styleable.IconBottomTextView_text, R.string.app_name)
        val textColorRes = typedArray.getResourceId(R.styleable.IconBottomTextView_textColor, R.color.color)
        val topIconRes = typedArray.getResourceId(R.styleable.IconBottomTextView_topIcon, R.drawable.btn_radio_off_mtrl)

        with(textView_iconText) {
            setText(textRes)
            setTextColor(resources.getColor(textColorRes))
            setCompoundDrawables(null, resources.getDrawable(topIconRes), null, null)
        }

        typedArray.recycle()
    }

}
