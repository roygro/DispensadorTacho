package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistorialActivity : AppCompatActivity() {

    private lateinit var tvHistorial: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        tvHistorial = findViewById(R.id.tvHistorial)
        val pacienteId = 1  // Puedes cambiar esto según el paciente autenticado

        val historialService = RetrofitInstance.createService(HistorialService::class.java)
        historialService.getHistorial(pacienteId).enqueue(object : Callback<List<HistorialResponse>> {
            override fun onResponse(call: Call<List<HistorialResponse>>, response: Response<List<HistorialResponse>>) {
                if (response.isSuccessful) {
                    val historial = response.body()
                    val texto = StringBuilder()

                    historial?.forEach { h ->
                        texto.append("Medicamento: ${h.medicamento}\n")
                        texto.append("Dosis: ${h.dosis_aplicada}\n")
                        texto.append("¿La tomó?: ${if (h.selatomado) "Sí" else "No"}\n")
                        texto.append("Hora: ${h.hora_aplicacion}\n\n")
                    }

                    tvHistorial.text = texto.toString()
                } else {
                    tvHistorial.text = "Error al cargar historial."
                }
            }

            override fun onFailure(call: Call<List<HistorialResponse>>, t: Throwable) {
                tvHistorial.text = "Error: ${t.message}"
            }
        })
    }
}

