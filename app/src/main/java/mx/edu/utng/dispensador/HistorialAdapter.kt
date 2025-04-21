package mx.edu.utng.dispensador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistorialAdapter(private val historialList: List<HistorialResponse>) :
    RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {

    class HistorialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMedicamento: TextView = itemView.findViewById(R.id.tvMedicamento)
        val tvDosisAplicada: TextView = itemView.findViewById(R.id.tvDosisAplicada)
        val tvTomado: TextView = itemView.findViewById(R.id.tvTomado)
        val tvHora: TextView = itemView.findViewById(R.id.tvHora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_historial, parent, false)
        return HistorialViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        val historial = historialList[position]
        holder.tvMedicamento.text = "Medicamento: ${historial.medicamento}"
        holder.tvDosisAplicada.text = "Dosis: ${historial.dosis_aplicada}"
        holder.tvTomado.text = "¿La tomó?: ${if (historial.selatomado) "Sí" else "No"}"
        holder.tvHora.text = "Hora: ${historial.hora_aplicacion}"
    }

    override fun getItemCount(): Int = historialList.size
}
