package alexandra.rodriguez.popcorn_factory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.title_seats)
        val boton: Button = findViewById(R.id.confirm)

        var selectedOption = ""
        var posMovie = -1
        var header = -1
        var asientosDisponibles = 0
        val bundle = intent.extras

        if(bundle != null) {
            title.setText(bundle.getString("titulo"))
            posMovie = bundle.getInt("movie")
            header = bundle.getInt("header")
            asientosDisponibles = bundle.getInt("seatsAvailable")
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)


        for (i in 0 until row1.childCount) {
            val checadorRadioButton = row1.getChildAt(i) as RadioButton
            if (bundle != null) {
                for (j in 0 until 25) {
                    if ((checadorRadioButton.text).equals(bundle.getString("asientoTomado$j"))) {
                        checadorRadioButton.isEnabled = false
                        checadorRadioButton.background = ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                    }
                }
            }
        }
        for (i in 0 until row2.childCount) {
            val checadorRadioButton = row2.getChildAt(i) as RadioButton
            if (bundle != null) {
                for (j in 0 until 30) {
                    if ((checadorRadioButton.text).equals(bundle.getString("asientoTomado$j"))) {
                        checadorRadioButton.isEnabled = false
                        checadorRadioButton.background = ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                    }
                }
            }
        }
        for (i in 0 until row3.childCount) {
            val checadorRadioButton = row3.getChildAt(i) as RadioButton
            if (bundle != null) {
                for (j in 0 until 35) {
                    if ((checadorRadioButton.text).equals(bundle.getString("asientoTomado$j"))) {
                        checadorRadioButton.isEnabled = false
                        checadorRadioButton.background = ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                    }
                }
            }
        }
        for (i in 0 until row4.childCount) {
            val checadorRadioButton = row4.getChildAt(i) as RadioButton
            if (bundle != null) {
                for (j in 0 until 40) {
                    if ((checadorRadioButton.text).equals(bundle.getString("asientoTomado$j"))) {
                        checadorRadioButton.isEnabled = false
                        checadorRadioButton.background = ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                    }
                }
            }
        }

        row1.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)

                val selectedRadioButton = findViewById<RadioButton>(checkedId)
                selectedOption = selectedRadioButton.text as String

            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
                val selectedRadioButton = findViewById<RadioButton>(checkedId)
                selectedOption = selectedRadioButton.text as String

            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
                val selectedRadioButton = findViewById<RadioButton>(checkedId)
                selectedOption = selectedRadioButton.text as String

            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
                val selectedRadioButton = findViewById<RadioButton>(checkedId)
                selectedOption = selectedRadioButton.text as String

            }
        }

        boton.setOnClickListener {
            if(selectedOption == "") {
                Toast.makeText(this, "Choose a seat", Toast.LENGTH_LONG).show()
            }else {
                val builder = AlertDialog.Builder(this@SeatSelection)
                val view = layoutInflater.inflate(R.layout.nombre_alert, null)

                builder.setView(view)

                val dialog = builder.create()
                dialog.show()

                val cajaNombre = view.findViewById(R.id.caja_nombre) as EditText
                val botonNombre = view.findViewById(R.id.confirm_nombre) as Button

                botonNombre.setOnClickListener {
                    val intent: Intent = Intent(this, ResumenActivity::class.java)
                    val titulo = bundle?.getString("titulo").toString()
                    if (cajaNombre.text.toString() == "") {
                        Toast.makeText(this, "Write your name", Toast.LENGTH_LONG).show()
                    } else {
                        intent.putExtra("nombre", cajaNombre.text.toString())
                        intent.putExtra("titulo", titulo)
                        intent.putExtra("asiento", selectedOption)
                        intent.putExtra("id", posMovie)
                        intent.putExtra("header", header)
                        intent.putExtra("asientosDisponiblesSeat", asientosDisponibles)
                        Toast.makeText(this, "Enjoy the movie", Toast.LENGTH_LONG).show()
                        if(asientosDisponibles < 20){
                            var i = 0
                            if(bundle != null) {
                                while (i < (20 - asientosDisponibles)) {
                                    var elementoBundle:String = bundle.getString("asientoTomado$i").toString()
                                    intent.putExtra("asientoTomado$i", elementoBundle)
                                    Log.d("SELECT ASI", "$elementoBundle")
                                    i++
                                }
                            }
                        }
                        this.startActivity(intent)
                    }
                }
            }
        }
    }

}