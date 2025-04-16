package mx.edu.utng.dispensador

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnPaciente = findViewById<Button>(R.id.btnRegistrarPaciente)
        val btnMedicamento = findViewById<Button>(R.id.btnRegistrarMedicamento)
        val btnProgramar = findViewById<Button>(R.id.btnProgramarDispensacion)
        val btnHistorial = findViewById<Button>(R.id.btnHistorial)

        btnPaciente.setOnClickListener {
            val intent = Intent(this, RegistrarPacienteActivity::class.java)
            startActivity(intent)
        }


        btnMedicamento.setOnClickListener {
            Toast.makeText(this, "Registrar Medicamento", Toast.LENGTH_SHORT).show()
        }

        btnProgramar.setOnClickListener {
            Toast.makeText(this, "Programar Dispensación", Toast.LENGTH_SHORT).show()
        }

        btnHistorial.setOnClickListener {
            Toast.makeText(this, "Historial", Toast.LENGTH_SHORT).show()
        }
    }
}