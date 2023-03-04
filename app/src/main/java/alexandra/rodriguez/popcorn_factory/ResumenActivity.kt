package alexandra.rodriguez.popcorn_factory

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val titulo: TextView = findViewById(R.id.textView)
        val nombre: TextView = findViewById(R.id.textView2)
        val asiento: TextView = findViewById(R.id.textView3)
        val header: ImageView = findViewById(R.id.resumen_image_header)
        val boton: Button = findViewById(R.id.home)


        val bundle = intent.extras
        var nombreIntent = ""
        var asientoIntent = ""
        var pelicula = ""
        var asientosDisponibles = 0
        var posMovie: Int = 0

        if(bundle != null) {
            nombreIntent = bundle.getString("nombre").toString()
            asientoIntent = bundle.getString("asiento").toString()
            pelicula = bundle.getString("titulo").toString()
            posMovie = bundle.getInt("id")
            asientosDisponibles = bundle.getInt("seatsAvailable")
            header.setImageResource(bundle.getInt("header"))
            titulo.setText("You buy a ticket for " + pelicula)
            nombre.setText("Thanks for buying, " + nombreIntent + "!")
            asiento.setText("The seat number is " + asientoIntent)
        }
        boton.setOnClickListener {
            var intento = Intent(this, CatalogActivity::class.java)
            intento.putExtra("nombre",  nombreIntent)
            intento.putExtra("asiento",  asientoIntent)
            intento.putExtra("peliculaNombre", pelicula)
            intento.putExtra("idMovie", posMovie)
            intento.putExtra("asientosDisponibles", asientosDisponibles)

            if(asientosDisponibles < 20){
                var i = 0
                if(bundle != null) {
                    while (i < (20 - asientosDisponibles)) {
                        var elementoBundle:String = bundle.getString("asientoTomado$i").toString()
                        intent.putExtra("asientoTomado$i", elementoBundle)
                        i++
                    }
                }
            }
            this.startActivity(intento)
        }
    }
}
