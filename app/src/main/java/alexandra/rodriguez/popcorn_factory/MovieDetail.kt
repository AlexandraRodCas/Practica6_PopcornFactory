package alexandra.rodriguez.popcorn_factory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var headerMandar = -1
        var title= ""

        val header: ImageView = findViewById(R.id.detail_image_header)
        val sinopsis: TextView = findViewById(R.id.detail_sinopsis)
        val titulo: TextView = findViewById(R.id.detail_titulo)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val buy_tickets: Button = findViewById(R.id.buy_tickets)
        if(bundle != null) {

            ns=bundle.getInt("numberSeats")

            title=bundle.getString("titulo").toString()
            header.setImageResource(bundle.getInt("header"))
            titulo.setText(bundle.getString("titulo").toString())
            sinopsis.setText(bundle.getString("sinopsis").toString())
            seatsLeft.setText("$ns seats available")
            headerMandar = bundle.getInt("header")
            id = bundle.getInt("movie")



        }
        if(ns == 0){
            buy_tickets.isEnabled = false
        } else{
            buy_tickets.isEnabled = true
            buy_tickets.setOnClickListener{
                val intent: Intent = Intent(this, SeatSelection::class.java)
                intent.putExtra("header", headerMandar)
                intent.putExtra("seatsAvailable", ns)
                intent.putExtra("movie", id)
                intent.putExtra("titulo", title)
                if(ns<20){
                    var i = 0
                    if(bundle != null) {
                        while (i < (20 - ns)) {
                            var elementoBundle:String = bundle.getString("asientoTomado$i").toString()
                            intent.putExtra("asientoTomado$i", elementoBundle)

                            i++
                        }
                    }
                }
                this.startActivity(intent)
            }
        }
    }
}