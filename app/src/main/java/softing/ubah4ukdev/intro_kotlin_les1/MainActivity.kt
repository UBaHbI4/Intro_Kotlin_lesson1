package softing.ubah4ukdev.intro_kotlin_les1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_show_property: MaterialButton
        btn_show_property = findViewById(R.id.btn_show_properties)
        btn_show_property?.setOnClickListener({
            Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show()
        })
    }
}