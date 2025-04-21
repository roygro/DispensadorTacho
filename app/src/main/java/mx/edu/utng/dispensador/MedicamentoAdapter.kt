package mx.edu.utng.dispensador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicamentoAdapter(private val lista: List<Medicamento>) :
    RecyclerView.Adapter<MedicamentoAdapter.MedicamentoViewHolder>() {

    class MedicamentoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombreMedicamento)
        val tvTipo: TextView = view.findViewById(R.id.tvTipoMedicamento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicamento, parent, false)
        return MedicamentoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        val medicamento = lista[position]
        holder.tvNombre.text = "Nombre: ${medicamento.nombre}"
        holder.tvTipo.text = "Tipo: ${obtenerNombreTipo(medicamento.tipo)}"
    }

    override fun getItemCount(): Int = lista.size

    // Función para convertir el tipo de medicamento de Int a String
    private fun obtenerNombreTipo(tipo: Int): String {
        return when (tipo) {
            1 -> "Pastillas"
            2 -> "Jarabe"
            3 -> "Inyectable"
            else -> "Desconocido"
        }
    }
}
