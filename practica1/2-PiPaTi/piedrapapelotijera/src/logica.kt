import kotlin.random.Random
fun pipati() {
    var opcion : Int
    do {
        println("Elija una opción")
        println("1. Piedra\n2. Papel\n3. Tijera")
        opcion = readln().toInt()
        if (opcion !in 1..3) {
            println("Opción inválida, vuelva a intentar")
        }
    }while(opcion !in 1..3)
    val pcplay : Int = Random.nextInt(1, 3)
    print("PC eligió: ")
    when(pcplay) {
        1 -> println("Piedra")
        2 -> println("Papel")
        3 -> println("Tijera")
    }
    if (opcion == pcplay) println("Empate!")
    else if (pcplay == opcion + 1) println("Perdiste!")
    else println("Ganaste!")
}