import java.util.*

fun main(args: Array<String>) {

var aleatoire = Random().nextInt(50)
    var welcomenot = when (aleatoire){
        in 1..10 -> "OK 1 to 10"
        in 11..20 -> "OK 11 to 20"
        else -> "nothing!"
    }

println(welcomenot)

}