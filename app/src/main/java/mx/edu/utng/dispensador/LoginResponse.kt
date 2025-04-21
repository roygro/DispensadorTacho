package mx.edu.utng.dispensador

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val admin: Admin?
)

data class Admin(
    val id: Int,
    val nombre: String,
    val email: String
)
