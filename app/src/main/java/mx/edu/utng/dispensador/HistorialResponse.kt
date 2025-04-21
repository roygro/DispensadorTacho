package mx.edu.utng.dispensador

data class HistorialResponse(
    val medicamento: String,
    val dosis_aplicada: Float,
    val selatomado: Boolean,
    val hora_aplicacion: String
)

