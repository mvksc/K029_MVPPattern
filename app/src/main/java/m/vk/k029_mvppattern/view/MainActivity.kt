package m.vk.k029_mvppattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import m.vk.k029_mvppattern.R
import m.vk.k029_mvppattern.view.fragment.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.frameMain,
                LoginFragment.newInstance()
            )
            .commit()
    }
}
