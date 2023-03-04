package alexandra.rodriguez.popcorn_factory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat

class CatalogActivity : AppCompatActivity() {
    var adapter:PeliculaAdapter? =null
    var peliculas = ArrayList<Pelicula>()
    var clienteList: ArrayList<Cliente> = arrayListOf()
    var nombrePeliculaCliente: String = ""
    var asientosDisponiblesBundle:Int = 20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        val bundle = intent.extras


        if(bundle != null) {
            val nombreCliente = bundle.getString("nombre").toString()
            val asientoCliente = bundle.getString("asiento").toString()
            asientosDisponiblesBundle = bundle.getInt("asientosDisponiblesSeat")
            clienteList.add(Cliente(nombreCliente, asientoCliente))

            nombrePeliculaCliente = bundle.getString("peliculaNombre").toString()
            var i = 1

            Log.d("ASIENTOS", "$asientosDisponiblesBundle")

            if(asientosDisponiblesBundle<20){
                while (i < (20-asientosDisponiblesBundle)){
                    var i2 = i-1
                    var elementoBundle:String = bundle.getString("asientoTomado$i2").toString()
                    Log.d("ASIENTOS ARRAY", "$elementoBundle")
                    if(elementoBundle != null){
                        clienteList.add(Cliente("pato", elementoBundle))
                    }
                    i++
                }
            }
        }

        cargarPeliculas()
        adapter = PeliculaAdapter(this, peliculas)

        var gridPelis:GridView = findViewById(R.id.movies_catalog)

        gridPelis.adapter = adapter
    }
    fun cargarPeliculas(){

        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called ‘Big Hero 6.’",   arrayListOf()))
        peliculas.add(Pelicula("Inception",R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming.", arrayListOf()))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged.", arrayListOf()))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home.", arrayListOf()))
        peliculas.add(Pelicula("Fantastic beasts", R.drawable.fantasticbeasts, R.drawable.fantasticbeastsheader, "In 1926, British wizard and \"magizoologist\" Newton \"Newt\" Scamander arrives in New York City. He encounters Mary Lou Barebone, the non-magical (\"No-Maj\" or \"Muggle\") head of the New Salem Philanthropic Society, who preaches that witches and wizards are real and dangerous. Attempting to recapture a Niffler that escaped from his suitcase of magical creatures, Newt meets No-Maj Jacob Kowalski, an aspiring baker, and they unwittingly swap suitcases. ", arrayListOf()))
        peliculas.add(Pelicula("The Aeronauts",R.drawable.aeronauts, R.drawable.aeronautsheader, "In 1862 London, scientist James Glaisher and his pilot Amelia arrive for the launch of the largest balloon ever constructed. Despite being haunted by a vision of her late husband Pierre, Amelia keeps up the brave front and the balloon successfully launches to a cheering crowd. In a flashback, James appears before the Royal Society and explains his theory that the weather can be predicted, but his fellow scientists mock him and refuse to finance his studies. Returning home, he talks to his parents, who try to persuade him to pursue another avenue of science. On the balloon, James and Amelia start rising through the cloud layer.",arrayListOf()))
        peliculas.add(Pelicula("Spiderman into the spiderverse", R.drawable.spiderverse, R.drawable.spiderverseheader, "Miles Morales, a teenager who admires Spider-Man, struggles living up to the expectations of his parents, especially his father, police officer Jefferson Davis, who sees Spider-Man as a menace. After school, Miles secretly visits his uncle Aaron Davis, who brings Miles to an abandoned subway station where he can paint graffiti. While there, Miles is unknowingly bitten by a radioactive spider and, the next day, discovers it gave him spider-like abilities, including the power to turn invisible, and to emit electric venom blasts.", arrayListOf()))
        peliculas.add(Pelicula("1917",R.drawable.pelicula, R.drawable.pelicula_header,"On 6 April 1917, aerial reconnaissance has observed that the German army, which has pulled back from a sector of the Western Front in northern France, is not in retreat but has made a strategic withdrawal to the new Hindenburg Line, where they are waiting to overwhelm the British with artillery.", arrayListOf()))
        peliculas.add(Pelicula("Men in black",R.drawable.mib, R.drawable.mibheader, "After a government agency makes first contact with aliens in 1961, alien refugees live in secret on Earth by disguising themselves as humans. Men in Black (MIB) is a secret agency that polices these aliens, protects Earth from extraterrestrial threats, and uses memory-erasing neuralyzers to keep alien activity a secret. MIB agents have their former identities erased while retired agents are neuralyzed. ",arrayListOf()))
        peliculas.add(Pelicula("Harry Potter",R.drawable.harrypotter, R.drawable.harrypotterheader, "Late one night, Albus Dumbledore and Minerva McGonagall, professors at Hogwarts School of Witchcraft and Wizardry, along with the school's groundskeeper Rubeus Hagrid, deliver a recently orphaned infant named Harry Potter to his only remaining relatives, the Dursleys. Ten years later, Harry has lived a difficult life with the Dursleys. After inadvertently causing an accident during a family trip to London Zoo, Harry begins receiving unsolicited letters by owls. After he and the Dursleys escape to an island to avoid more letters, Hagrid re-appears and informs Harry that he is a wizard and has been accepted into Hogwarts against the Dursleys' wishes. After taking Harry to Diagon Alley to buy his supplies for Hogwarts and a pet owl named Hedwig as a birthday present, Hagrid informs him of his past: Harry's parents James and Lily Potter died due to a Killing Curse at the hands of the malevolent and all-powerful wizard: Lord Voldemort. Harry, the only survivor in the chaos, thus becomes well-known in the wizarding world as The Boy Who Lived",arrayListOf()))

        if(asientosDisponiblesBundle<20){
            var i = 1
            while (i<peliculas.size){
                if((peliculas[i].titulo).equals(nombrePeliculaCliente)){
                     clienteList
                    Log.d("LISTA CLIEN", "$clienteList")
                    peliculas[i].seat = clienteList
                    break
                }
                i++
            }
        }
    }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Pelicula>()
        var contexto: Context?=null

        constructor(contexto: Context, productos:ArrayList<Pelicula>){
            this.peliculas = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula=peliculas[p0]
            var inflador= contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflador.inflate(R.layout.cell_movie, null)

            var imagen = vista.findViewById(R.id.image_movie_cell) as ImageView
            var title = vista.findViewById(R.id.movie_title_cell) as TextView

            imagen.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            imagen.setOnClickListener {
                var seatsAvailable = 20-pelicula.seat.size
                var intento = Intent(contexto, MovieDetail::class.java)
                intento.putExtra("titulo", pelicula.titulo)
                intento.putExtra("sinopsis", pelicula.sinopsis)
                intento.putExtra("header", pelicula.header)
                intento.putExtra("image", pelicula.image)
                intento.putExtra("numberSeats", seatsAvailable)

                if(pelicula.seat.size >-1){
                    var i = 0
                    while (i < pelicula.seat.size) {
                        var elemento = pelicula.seat[i].asiento
                        intento.putExtra("asientoTomado$i", elemento)
                        Log.d("CATA ASI", "$elemento")

                        i++
                    }
                }

                intento.putExtra("pos", p0)

                contexto!!.startActivity(intento)
            }
            return vista
        }
    }
}