package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicamentosActivity : AppCompatActivity() {

    private lateinit var tvMedicamentos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)

        tvMedicamentos = findViewById(R.id.tvMedicamentos)

        val medicamentoService = RetrofitInstance.createService(MedicamentoService::class.java)
        medicamentoService.getMedicamentos().enqueue(object : Callback<List<Medicamento>> {
            override fun onResponse(
                call: Call<List<Medicamento>>,
                response: Response<List<Medicamento>>
            ) {
                if (response.isSuccessful) {
                    val medicamentos = response.body()
                    val texto = StringBuilder()

                    medicamentos?.forEach { m ->
                        texto.append("Nombre: ${m.nombre}\n")
                        texto.append("Tipo: ${m.tipo}\n\n")
                    }

                    tvMedicamentos.text = texto.toString()
                } else {
                    tvMedicamentos.text = "Error al cargar medicamentos."
                    Toast.makeText(this@MedicamentosActivity, "Error al cargar medicamentos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Medicamento>>, t: Throwable) {
                tvMedicamentos.text = "Error: ${t.message}"
                Toast.makeText(this@MedicamentosActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
