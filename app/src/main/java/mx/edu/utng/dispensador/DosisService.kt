package mx.edu.utng.dispensador


import retrofit2.Call
import retrofit2.http.GET

interface DosisService {

    // Método para obtener todas las dosis
    @GET("dosis")
    fun getAllDosis(): Call<List<DosisResponse>>
}
