package masson.reynoso.mydigimind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ContrasenaActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrasena)

        auth = Firebase.auth

        val btn_restablecer: Button = findViewById(R.id.btn_restablecer)
        val tv_inicio_sesion: TextView = findViewById(R.id.tv_iniciarSesion)

        btn_restablecer.setOnClickListener {
            validaCorreo()
        }

        tv_inicio_sesion.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }

    }

    private fun validaCorreo() {

        val et_correo: EditText = findViewById(R.id.correoElectronico)
        var correo: String = et_correo.text.toString()

        if(!correo.isNullOrBlank()){
            auth.sendPasswordResetEmail(correo)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Se envióo un correo a ${correo}", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Error al enviar correo", Toast.LENGTH_SHORT).show()
                    }
                }
        }else{
            Toast.makeText(this,"Ingresar datos", Toast.LENGTH_SHORT).show()
        }
    }
}