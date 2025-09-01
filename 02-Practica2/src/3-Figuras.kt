/**
 * Figuras.kt
 * Jerarquía de clases: Shape (abstracta), Cuadrado, Circulo y Rectangulo.
 */

import kotlin.math.PI

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    init {
        require(lado > 0) { "El lado del cuadrado debe ser positivo." }
    }
    constructor(ladoStr: String) : this(ladoStr.toDouble())

    override fun calcularArea(): Double = lado * lado
    override fun calcularPerimetro(): Double = 4 * lado
}

class Circulo(private val radio: Double) : Shape() {
    init {
        require(radio > 0) { "El radio del círculo debe ser positivo." }
    }
    constructor(radioStr: String) : this(radioStr.toDouble())

    override fun calcularArea(): Double = PI * radio * radio
    override fun calcularPerimetro(): Double = 2 * PI * radio
}

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    init {
        require(largo > 0 && ancho > 0) { "El largo y el ancho del rectángulo deben ser positivos." }
    }
    constructor(largoStr: String, anchoStr: String) : this(largoStr.toDouble(), anchoStr.toDouble())

    override fun calcularArea(): Double = largo * ancho
    override fun calcularPerimetro(): Double = 2 * (largo + ancho)
}