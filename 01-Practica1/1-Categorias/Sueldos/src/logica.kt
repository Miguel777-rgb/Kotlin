fun category (){
    var nivelRendimiento: Int
    do {
        println("Ingrese su categoría (0-10)")
        nivelRendimiento = readln().toInt()
        if (nivelRendimiento !in 0..10) {
            println("⚠ Categoría inválida, intente nuevamente.")
        }
    }while (nivelRendimiento !in 0..10)
    var categoria : String = "Desconocidofloo"
    when(nivelRendimiento){
        in 1..3 -> categoria = "Inaceptable"
        in 4..6 -> categoria = "Aceptable"
        in 7..10 -> categoria = "Meritorio"
        else -> println("Nivel fuera de rango")
    }
    println("Ingrese su sueldo actual")
    val sueldosRendimiento = readln().toFloat()
    val sueldoFinal : Float = sueldosRendimiento*nivelRendimiento/10
    print ("Resultado: Nivel de Rendimiento $categoria, Cantidad de Dinero Recibido $ $sueldoFinal")

}