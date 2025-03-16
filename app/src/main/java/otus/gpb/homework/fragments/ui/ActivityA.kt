package otus.gpb.homework.fragments.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import otus.gpb.homework.fragments.R

class ActivityA : AppCompatActivity() {
    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        if (savedInstanceState == null) {
            fragmentA = FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentA, "fragmentA")
                .commit()
        }
    }
}