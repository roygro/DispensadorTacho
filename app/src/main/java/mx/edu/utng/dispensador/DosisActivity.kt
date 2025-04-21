package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DosisActivity : AppCompatActivity() {

    private lateinit var tvDosis: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosis)

        tvDosis = findViewById(R.id.tvDosis)

        // Crear una instancia del servicio
        val dosisService = RetrofitInstance.createService(DosisService::class.java)

        // Hacer la llamada a la API
        dosisService.getAllDosis().enqueue(object : Callback<List<DosisResponse>> {
            override fun onResponse(
                call: Call<List<DosisResponse>>,
                response: Response<List<DosisResponse>>
            ) {
                if (response.isSuccessful) {
                    val dosisList = response.body()
                    val texto = StringBuilder()

                    dosisList?.forEach { dosis ->
                        texto.append("Medicamento: ${dosis.medicamento}\n")
                        texto.append("Cantidad: ${dosis.cantidad}\n\n")
                    }

                    tvDosis.text = texto.toString()

                } else {
                    tvDosis.text = "Error al obtener las dosis."
                    Toast.makeText(this@DosisActivity, "Error al obtener las dosis", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<DosisResponse>>, t: Throwable) {
                tvDosis.text = "Error de conexión: ${t.message}"
                Toast.makeText(this@DosisActivity, "Error de conexión: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
