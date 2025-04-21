package mx.edu.utng.dispensador

import retrofit2.Call
import retrofit2.http.GET

interface MedicamentoService {
    @GET("medicamentos")
    fun getMedicamentos(): Call<List<Medicamento>>
}
