# Kotlin GOD :D
 
---

# 📖 Guía Rápida de Kotlin: Entrada de Usuario y Valores Aleatorios

Este documento sirve como una guía básica para manejar dos operaciones comunes en Kotlin: leer datos desde el teclado y generar valores aleatorios.

---

## 🔹 Leer datos por teclado con `readln()`

La función `readln()` es la forma estándar en Kotlin para leer una **línea completa como `String`** desde la entrada estándar (generalmente, el teclado). Si necesitas otros tipos de datos como números, deberás realizar una conversión manual.

### Ejemplo Básico

```kotlin
fun main() {
    // Pedimos el nombre al usuario
    println("Ingresa tu nombre:")
    val nombre: String = readln()

    // Pedimos la edad y la convertimos a Entero
    println("Ingresa tu edad:")
    val edad: Int = readln().toInt()

    // Mostramos el resultado
    println("Hola $nombre, tienes $edad años.")
}
```
---

## 🔹 Generar valores aleatorios con `Random`

Para generar números (y otros valores) aleatorios, Kotlin proporciona la clase `kotlin.random.Random`, que es muy flexible y fácil de usar.

### Ejemplos Comunes

```kotlin
import kotlin.random.Random

fun main() {
    // 1. Número entero aleatorio entre 0 y 99
    val num1 = Random.nextInt(100)
    println("Número aleatorio (0..99): $num1")

    // 2. Número entero aleatorio dentro de un rango específico (de 50 a 100)
    val num2 = Random.nextInt(50, 101) // El límite superior es exclusivo
    println("Número aleatorio (50..100): $num2")

    // 3. Número decimal aleatorio entre 0.0 y 1.0
    val num3 = Random.nextDouble()
    println("Decimal aleatorio (0.0..1.0): $num3")

    // 4. Booleano aleatorio (true o false)
    val flag = Random.nextBoolean()
    println("Boolean aleatorio: $flag")
}
```

---

## 🚀 Ejemplo práctico: Adivina el número

Este programa combina `readln()` y `Random`. El usuario definirá un rango de números y luego intentará adivinar un número secreto generado aleatoriamente dentro de ese rango.

```kotlin
import kotlin.random.Random

fun main() {
    println("--- ¡Juego de Adivinar el Número! ---")

    // 1. El usuario define el rango
    println("Ingresa el número mínimo del rango:")
    val min = readln().toInt()

    println("Ingresa el número máximo del rango:")
    val max = readln().toInt()

    // 2. Se genera un número aleatorio secreto
    val numeroSecreto = Random.nextInt(min, max + 1)
    var intentos = 0
    var adivinado = false

    println("\nHe generado un número entre $min y $max. ¡Intenta adivinarlo!")

    // 3. Bucle para que el usuario adivine
    while (!adivinado) {
        print("Ingresa tu número: ")
        val intentoUsuario = readln().toInt()
        intentos++

        when {
            intentoUsuario < numeroSecreto -> println("¡Muy bajo! Intenta de nuevo.")
            intentoUsuario > numeroSecreto -> println("¡Muy alto! Intenta de nuevo.")
            else -> {
                adivinado = true
                println("🎉 ¡Felicidades! Adivinaste el número $numeroSecreto en $intentos intentos.")
            }
        }
    }
}
```

### ¿Cómo funciona este script?
1.  **Definición del Rango**: Primero, le pide al usuario un valor mínimo y uno máximo usando `readln().toInt()`.
2.  **Generación Aleatoria**: Utiliza `Random.nextInt(min, max + 1)` para crear un número secreto dentro del rango inclusivo que el usuario especificó.
3.  **Bucle de Juego**: Entra en un bucle `while` que no se detendrá hasta que el número sea adivinado. En cada iteración:
    *   Lee el intento del usuario.
    *   Compara el intento con el número secreto y da una pista ("muy bajo" o "muy alto").
    *   Si el usuario acierta, se muestra un mensaje de felicitación con el número de intentos y el bucle termina.
