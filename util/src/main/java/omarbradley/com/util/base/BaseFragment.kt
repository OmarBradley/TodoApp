package omarbradley.com.util.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

abstract class BaseFragment : Fragment() {

    protected inline fun <T> LiveData<T>.observe(crossinline observer: (T) -> Unit) =
        this.observe(this@BaseFragment, Observer { observer(it) })
}
