package masson.reynoso.mydigimind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdaptadorTareas: BaseAdapter {
    lateinit var context: Context
    var tasks: ArrayList<Recordatorio> = ArrayList<Recordatorio>()

    constructor(contexto: Context, task: ArrayList<Recordatorio>) {
        this.context = contexto
        this.tasks = tasks
    }

    override fun getCount(): Int {
        return tasks.size
    }

    override fun getItem(p0: Int): Any {
        return tasks[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflador = LayoutInflater.from(context)
        var vista = inflador.inflate(R.layout.recordatorio, null)
        var task = tasks[p0]

        val title: TextView = vista.findViewById(R.id.txt_nombre_recordatorio)
        val days: TextView = vista.findViewById(R.id.txt_dias_recordatorio)
        val time: TextView = vista.findViewById(R.id.txt_tiempo_recordatorio)

        title.text = task.nombre
        days.text = task.dias
        time.text = task.tiempo

        return vista
    }
}