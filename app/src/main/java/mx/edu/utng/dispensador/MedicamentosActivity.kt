package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicamentosActivity : AppCompatActivity() {

    private lateinit var rvMedicamentos: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)

        rvMedicamentos = findViewById(R.id.rvMedicamentos)
        rvMedicamentos.layoutManager = LinearLayoutManager(this)
        rvMedicamentos.setHasFixedSize(true)

        // Obtener medicamentos desde la API
        val medicamentoService = RetrofitInstance.createService(MedicamentoService::class.java)
        medicamentoService.getMedicamentos().enqueue(object : Callback<List<Medicamento>> {
            override fun onResponse(
                call: Call<List<Medicamento>>,
                response: Response<List<Medicamento>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val lista = response.body()!!
                    rvMedicamentos.adapter = MedicamentoAdapter(lista)
                } else {
                    Toast.makeText(
                        this@MedicamentosActivity,
                        "Error al cargar medicamentos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Medicamento>>, t: Throwable) {
                Toast.makeText(
                    this@MedicamentosActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}
