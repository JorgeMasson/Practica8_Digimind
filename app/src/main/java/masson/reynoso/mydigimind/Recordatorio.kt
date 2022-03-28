package masson.reynoso.mydigimind
import java.io.Serializable

data class Recordatorio(var nombre: String,
                        var dias: String,
                        var tiempo: String) : Serializable