package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrarPacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_paciente)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarPaciente)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val edad = etEdad.text.toString()
            val telefono = etTelefono.text.toString()
            val direccion = etDireccion.text.toString()

            if (nombre.isEmpty() || edad.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí iría el envío a la base de datos (más adelante)
                Toast.makeText(this, "Paciente guardado (simulado)", Toast.LENGTH_SHORT).show()
                etNombre.text.clear()
                etEdad.text.clear()
                etTelefono.text.clear()
                etDireccion.text.clear()
            }
        }
    }
}
