package mx.edu.utng.dispensador

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //RECUERDA DAR LOS PERMISOS EN NETWOR SECURITY
    // Aquí debes colocar la URL base de tu API (cambia esto por IP de tu dispositivo )
    //CAMBIAR IP SEGUN DONDE SE CONECTE (SE CAMBIA AQUI Y EN xml>network_security_config.xml
   // private const val BASE_URL = "http://192.168.1.87:3000/api/" //para el movil
   private const val BASE_URL = "http://10.0.2.2:3000/api/" //probar en el emulador
    // private const val BASE_URL = "http://192.168.1.104:3000/api/" //para el movil House Andy




    // Crear cliente OkHttp para manejar conexiones
    private val client = OkHttpClient.Builder()
        .build()

    // Crear la instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)  // Se pasa el cliente OkHttp configurado
        .addConverterFactory(GsonConverterFactory.create())  // Usar Gson para convertir las respuestas a objetos
        .build()

    // Función para obtener el servicio de Retrofit
    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }
}