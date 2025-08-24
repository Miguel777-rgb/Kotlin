import kotlin.random.Random
fun numerotre() {
    var trying: Int
    val num : Int = Random.nextInt(1,31)
    for (i in 1..4) {
        println("Ingrese un número del 1 al 30:")

        trying = readln().toInt()

        if (trying == num) {
            println("Ganaste! 🎉")
            return
        }

        val rango = (num-5).coerceAtLeast(1)..(num+5).coerceAtMost(30)

        if (trying in rango) {
            println("🔥 Caliente! Estás cerca")
        } else {
            println("🥶 Frío! Lejos del número")
        }
        var intentos : Int = 5 - i
        if (intentos == 1) { println("Te queda un solo intento!") }
        println ("te quedan $intentos intentos!")
    }
    println("Perdiste! El número era $num")
}