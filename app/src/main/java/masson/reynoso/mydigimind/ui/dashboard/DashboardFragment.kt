package masson.reynoso.mydigimind.ui.dashboard

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import masson.reynoso.mydigimind.R
import masson.reynoso.mydigimind.Recordatorio
import masson.reynoso.mydigimind.databinding.FragmentDashboardBinding
import masson.reynoso.mydigimind.databinding.FragmentHomeBinding
import masson.reynoso.mydigimind.ui.home.HomeFragment
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.Inflater

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnTime.setOnClickListener {
            set_time()
        }

        binding.btnSave.setOnClickListener {
            guardar()
        }

        return root
    }

    fun guardar() {
        var titulo: String = binding.etTask.text.toString()
        var tiempo: String = binding.btnSave.text.toString()
        var dia: String = ""

        if(binding.mondayCheck.isChecked) dia = getString(R.string.monday)
        if(binding.tuesdayCheck.isChecked) dia = getString(R.string.tuesday)
        if(binding.wednesdayCheck.isChecked) dia = getString(R.string.wednesday)
        if(binding.thursdayCheck.isChecked) dia = getString(R.string.thursday)
        if(binding.fridayCheck.isChecked) dia = getString(R.string.friday)
        if(binding.saturdayCheck.isChecked) dia = getString(R.string.saturday)
        if(binding.sundayCheck.isChecked) dia = getString(R.string.sunday)

        var tarea = Recordatorio(dia, tiempo, titulo)

        HomeFragment.tasks.add(tarea)

        Toast.makeText(context, "Se agregó la tarea", Toast.LENGTH_SHORT).show()
    }

    fun set_time() {
        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            binding.btnTime.text = SimpleDateFormat("HH:mm").format(cal.time)
        }
        TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    }

}