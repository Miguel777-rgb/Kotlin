/**
 * Main.kt
 * Punto de entrada único para ejecutar todos los ejercicios.
 */

fun main() {
    println("===== EJERCICIO 1: Cuenta Bancaria =====")
    val miCuenta = CuentaBancaria()
    miCuenta.saldo = 1000.0
    miCuenta.limiteRetiro = 500.0
    println("Saldo inicial: ${miCuenta.saldo}")
    println("Límite de retiro: ${miCuenta.limiteRetiro}")
    miCuenta.retirar(300.0)
    miCuenta.retirar(600.0) // excede el límite
    miCuenta.retirar(800.0) // saldo insuficiente
    miCuenta.saldo = -100.0 // saldo inválido
    println()

    println("===== EJERCICIO 2: Producto =====")
    val miProducto = Producto()
    miProducto.precio = 150.0
    miProducto.descuento = 20.0
    miProducto.calcularPrecioFinal()
    miProducto.descuento = 110.0 // descuento inválido
    miProducto.precio = -50.0    // precio inválido
    val otroProducto = Producto()
    otroProducto.precio = 200.0
    otroProducto.descuento = 10.0
    otroProducto.calcularPrecioFinal()

    println()

    println("===== EJERCICIO 3: Figuras =====")
    val miCuadrado = Cuadrado(5.0)
    miCuadrado.imprimirResultados()
    val miCirculo = Circulo(3.0)
    miCirculo.imprimirResultados()
    val miRectangulo = Rectangulo(6.0, 4.0)
    miRectangulo.imprimirResultados()

    println()

    println("===== EJERCICIO 4: Biblioteca =====")
    val biblioteca = Biblioteca()
    val libro1 = Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1954, "Fantasía", 1200)
    val libro2 = Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "Realismo Mágico", 496)
    val revista1 = Revista("National Geographic", "Varios", 2023, "0027-9358", 244, 10, "National Geographic Society")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)

    val usuario1 = Usuario("Ana", "García", 30)
    val usuario2 = Usuario("Pedro", "Martínez", 25)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.prestarMaterial(usuario2, revista1)
    biblioteca.prestarMaterial(usuario1, libro2)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2)

    biblioteca.devolverMaterial(usuario1, libro1)
    biblioteca.devolverMaterial(usuario2, revista1)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario2)
}