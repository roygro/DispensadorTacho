package mx.edu.utng.dispensador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DosisAdapter(private val dosisList: List<DosisResponse>) :
    RecyclerView.Adapter<DosisAdapter.DosisViewHolder>() {

    class DosisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMedicamento: TextView = itemView.findViewById(R.id.tvMedicamento)
        val tvCantidad: TextView = itemView.findViewById(R.id.tvCantidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosisViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dosis, parent, false)
        return DosisViewHolder(view)
    }

    override fun onBindViewHolder(holder: DosisViewHolder, position: Int) {
        val dosis = dosisList[position]
        holder.tvMedicamento.text = "Medicamento: ${dosis.medicamento}"
        holder.tvCantidad.text = "Cantidad: ${dosis.cantidad}"
    }

    override fun getItemCount(): Int = dosisList.size
}
