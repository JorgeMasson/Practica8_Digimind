package masson.reynoso.mydigimind.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import masson.reynoso.mydigimind.AdaptadorTareas
import masson.reynoso.mydigimind.R
import masson.reynoso.mydigimind.Recordatorio
import masson.reynoso.mydigimind.databinding.FragmentHomeBinding
import java.util.zip.Inflater

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    companion object {
        var tasks= ArrayList<Recordatorio>()
        var first = true
        lateinit var adaptador: AdaptadorTareas
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var gridView: GridView = binding.gridview

        /*if(first) {
            fill_tasks()
            first = false
        }*/

        cargar_tareas()
        Log.d("Lista", tasks.toString())

        adaptador = AdaptadorTareas(root.context, tasks)

        gridView.adapter = adaptador

        return root
    }

    fun fill_tasks() {
        tasks.add(Recordatorio("Tarea 1", "Lunes", "15:00"))
        tasks.add(Recordatorio("Tarea 2", "Lunes", "15:00"))
        tasks.add(Recordatorio("Tarea 3", "Lunes", "15:00"))
        tasks.add(Recordatorio("Tarea 4", "Lunes", "15:00"))
        tasks.add(Recordatorio("Tarea 5", "Lunes", "15:00"))
    }

    fun cargar_tareas() {
        val preferencias = context?.getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        val gson: Gson = Gson()

        var json = preferencias?.getString("tareas", null)
        val type = object : TypeToken<ArrayList<Recordatorio?>?>() {}.type

        if(json == null) {
            tasks = ArrayList<Recordatorio>()
        } else {
            tasks = gson.fromJson(json, type)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}