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

    constructor(context: Context, task: ArrayList<Recordatorio>) {
        this.context = context
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
        var vista = inflador.inflate(R.layout.task_view, null)

        var task = tasks[p0]

        var nombre: TextView = vista.findViewById(R.id.tv_title) as TextView
        var dias: TextView = vista.findViewById(R.id.tv_days) as TextView
        var tiempo: TextView = vista.findViewById(R.id.tv_time) as TextView

        nombre.setText(task.nombre)
        dias.setText(task.dias)
        tiempo.setText(task.tiempo)

        return vista
    }
}