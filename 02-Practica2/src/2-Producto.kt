/**
 * Producto.kt
 * Lógica de producto con precio, descuento y cálculo de precio final.
 */

class Producto {
    var precio: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                println("El precio no puede ser negativo. Precio actual: $field")
            }
        }

    var descuento: Double = 0.0
        set(value) {
            if (value in 0.0..100.0) { // Descuento entre 0 y 100%
                field = value
            } else {
                println("El descuento debe estar entre 0% y 100%. Descuento actual: $field%")
            }
        }

    fun calcularPrecioFinal(): Double {
        val precioFinal = precio * (1 - (descuento / 100))
        println("Precio original: $precio, Descuento: $descuento%, Precio final: $precioFinal")
        return precioFinal
    }
}