package omarbradley.com.todoapp

import android.os.Bundle
import androidx.navigation.findNavController
import omarbradley.com.util.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
