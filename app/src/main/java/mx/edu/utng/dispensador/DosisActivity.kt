package mx.edu.utng.dispensador

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DosisActivity : AppCompatActivity() {

    private lateinit var rvDosis: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosis)

        rvDosis = findViewById(R.id.rvDosis)
        rvDosis.layoutManager = LinearLayoutManager(this)

        val dosisService = RetrofitInstance.createService(DosisService::class.java)

        dosisService.getAllDosis().enqueue(object : Callback<List<DosisResponse>> {
            override fun onResponse(
                call: Call<List<DosisResponse>>,
                response: Response<List<DosisResponse>>
            ) {
                if (response.isSuccessful) {
                    val dosisList = response.body() ?: emptyList()
                    rvDosis.adapter = DosisAdapter(dosisList)
                } else {
                    Toast.makeText(this@DosisActivity, "Error al obtener las dosis", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<DosisResponse>>, t: Throwable) {
                Toast.makeText(this@DosisActivity, "Error de conexión: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}
