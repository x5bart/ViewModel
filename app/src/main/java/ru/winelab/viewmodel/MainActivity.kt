package ru.winelab.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.winelab.viewmodel.ui.main.MainFragment
const val TAG = "Mylog"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}