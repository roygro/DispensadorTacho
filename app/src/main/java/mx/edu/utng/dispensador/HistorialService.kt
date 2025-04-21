package mx.edu.utng.dispensador

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HistorialService {
    @GET("historial/{id}")
    fun getHistorial(@Path("id") pacienteId: Int): Call<List<HistorialResponse>>
}
