package masson.reynoso.mydigimind.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import masson.reynoso.mydigimind.AdaptadorTareas
import masson.reynoso.mydigimind.R
import masson.reynoso.mydigimind.Recordatorio
import masson.reynoso.mydigimind.databinding.FragmentHomeBinding
import java.util.zip.Inflater

class HomeFragment : Fragment() {
    var tasks= ArrayList<Recordatorio>()
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val gridView: GridView = binding.gridView

        fill_tasks()

        val adaptador = AdaptadorTareas(root.context, tasks)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}