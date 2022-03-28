package masson.reynoso.mydigimind

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import masson.reynoso.mydigimind.ui.home.HomeFragment

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

        vista.setOnClickListener {
            eliminar(task)
        }

        return vista
    }

    fun eliminar(task: Recordatorio) {
        val alertDialog = context?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.btn_ok,
                    {dialog, id ->
                        //User clicked OK button
                        HomeFragment.tasks.remove(task)
                        guardar_json()
                        HomeFragment.adaptador.notifyDataSetChanged()
                        Toast.makeText(context, R.string.msg_deleted, Toast.LENGTH_SHORT).show()
                    })
                setNegativeButton(R.string.cancel_button,
                    {dialog, it ->
                        //User cancelled the dialog
                    })
            }
            builder?.setMessage(R.string.msg).setTitle(R.string.title)
        }
    }

    fun  guardar_json() {
        val preferencias = context?.getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        val editor = preferencias?.edit()
        val gson: Gson = Gson()

        var json = gson.toJson(HomeFragment.tasks)

        editor?.putString("tareas", json)
        editor?.apply()
    }
}