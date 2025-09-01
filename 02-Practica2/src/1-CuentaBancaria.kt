/**
 * CuentaBancaria.kt
 * Lógica de cuenta bancaria con validaciones de saldo y límite de retiro.
 */

class CuentaBancaria {
    var saldo: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                println("El saldo no puede ser negativo. Saldo actual: $field")
            }
        }

    var limiteRetiro: Double = 0.0
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                println("El límite de retiro no puede ser negativo. Límite actual: $field")
            }
        }

    fun retirar(cantidad: Double): Boolean {
        if (cantidad <= 0) {
            println("La cantidad a retirar debe ser positiva.")
            return false
        }
        if (cantidad > limiteRetiro) {
            println("No se puede retirar $cantidad. Excede el límite de retiro de $limiteRetiro.")
            return false
        }
        if (cantidad > saldo) {
            println("Saldo insuficiente. No se puede retirar $cantidad. Saldo actual: $saldo.")
            return false
        }
        saldo -= cantidad
        println("Retiro exitoso. Nuevo saldo: $saldo")
        return true
    }
}