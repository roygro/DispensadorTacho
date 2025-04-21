package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistorialActivity : AppCompatActivity() {

    private lateinit var rvHistorial: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        rvHistorial = findViewById(R.id.rvHistorial)
        rvHistorial.layoutManager = LinearLayoutManager(this)

        val pacienteId = 1 // Reemplaza con el ID real si es necesario
        val historialService = RetrofitInstance.createService(HistorialService::class.java)

        historialService.getHistorial(pacienteId).enqueue(object : Callback<List<HistorialResponse>> {
            override fun onResponse(
                call: Call<List<HistorialResponse>>,
                response: Response<List<HistorialResponse>>
            ) {
                if (response.isSuccessful) {
                    val historialList = response.body() ?: emptyList()
                    rvHistorial.adapter = HistorialAdapter(historialList)
                } else {
                    Toast.makeText(this@HistorialActivity, "Error al obtener historial", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<HistorialResponse>>, t: Throwable) {
                Toast.makeText(this@HistorialActivity, "Error de conexión: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
