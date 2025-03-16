package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.ui.ActivityA
import otus.gpb.homework.fragments.ui.ActivityB
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonOpenActivityA).setOnClickListener{
            startActivity(Intent(this@MainActivity, ActivityA::class.java))
        }

        findViewById<Button>(R.id.buttonOpenActivityB).setOnClickListener{
            startActivity(Intent(this@MainActivity, ActivityB::class.java))
        }
    }

}