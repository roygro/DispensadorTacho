package mx.edu.utng.dispensador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnDosis: Button
    private lateinit var btnHistorial: Button
    private lateinit var btnMedicamentos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Asegúrate de que tu layout tenga estos botones

        btnDosis = findViewById(R.id.btnDosis)
        btnHistorial = findViewById(R.id.btnHistorial)
        btnMedicamentos = findViewById(R.id.btnMedicamentos)

        btnDosis.setOnClickListener {
            startActivity(Intent(this, DosisActivity::class.java))
        }

        btnHistorial.setOnClickListener {
            startActivity(Intent(this, HistorialActivity::class.java))
        }

        btnMedicamentos.setOnClickListener {
            startActivity(Intent(this, MedicamentosActivity::class.java))
        }
    }
}
