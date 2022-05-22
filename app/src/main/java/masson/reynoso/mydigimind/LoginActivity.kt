package masson.reynoso.mydigimind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_Registrar: Button = findViewById(R.id.btn_registrarse)
        val contrasena: TextView = findViewById(R.id.tv_olvidasteContra)
        val btn_IniciarSesion: Button = findViewById(R.id.btn_iniciarSesion)

        btn_Registrar.setOnClickListener {
            val intent: Intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
        }

        contrasena.setOnClickListener {
            val intent: Intent = Intent(this,ContrasenaActivity::class.java)
            startActivity(intent)
        }

        btn_IniciarSesion.setOnClickListener {
            validaSesion()
        }

    }

    private fun validaSesion() {

        val et_correo: EditText = findViewById(R.id.correoElectronico)
        val et_contra: EditText = findViewById(R.id.contraseña)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if(!correo.isNullOrBlank() && contra.isNullOrBlank()){

        }else{
            Toast.makeText(this,"Ingresar datos",Toast.LENGTH_SHORT).show()
        }


    }

}