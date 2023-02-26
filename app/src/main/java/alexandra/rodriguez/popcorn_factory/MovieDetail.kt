package alexandra.rodriguez.popcorn_factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundleHeader = intent.extras
        val datoHeader = bundleHeader?.getInt("header")

        val bundleTitulo = intent.extras
        val datoTitulo = bundleTitulo?.getString("titulo")

        val bundleSinopsis = intent.extras
        val datoSinopsis = bundleTitulo?.getString("sinopsis")

        var header: ImageView = findViewById(R.id.detail_image_header)
        if (datoHeader != null) {
            header.setImageResource(datoHeader)
        }

        var titulo: TextView = findViewById(R.id.detail_titulo)
        titulo.setText(datoTitulo.toString())

        var sinopsis: TextView = findViewById(R.id.detail_sinopsis)
        sinopsis.setText(datoSinopsis.toString())

    }
}