package mx.edu.utng.dispensador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnDosis = findViewById<Button>(R.id.btnDosis)
        val btnHistorial = findViewById<Button>(R.id.btnHistorial)
        val btnMedicamentos = findViewById<Button>(R.id.btnMedicamentos)

        btnDosis.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) // Dosis
        }

        btnHistorial.setOnClickListener {
            startActivity(Intent(this, HistorialActivity::class.java)) // Historial
        }

        btnMedicamentos.setOnClickListener {
            startActivity(Intent(this, MedicamentosActivity::class.java)) // Medicamentos
        }
    }
}
