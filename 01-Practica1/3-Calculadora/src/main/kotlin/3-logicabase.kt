class CalculadoraLogica {
    private var currentNumber: String = "0"
    private var previousNumber: String = ""
    private var currentOperator: String = ""
    private var resetDisplay: Boolean = false // Indica si la pantalla debe limpiarse antes de añadir el siguiente número

    /**
     * Procesa la entrada del botón presionado y devuelve la cadena a mostrar en la pantalla.
     */
    fun processInput(input: String): String {
        when (input) {
            in "0".."9" -> appendNumber(input)
            in "+", "-", "*", "/" -> setOperator(input)
            "=" -> calculateResult()
            "C" -> clearAll()
        }
        return currentNumber // Devuelve el número actual para mostrar en la IU
    }

    private fun appendNumber(number: String) {
        if (resetDisplay) {
            currentNumber = number
            resetDisplay = false
        } else {
            if (currentNumber == "0" && number != ".") { // Evitar múltiplos 0s al inicio
                currentNumber = number
            } else {
                currentNumber += number
            }
        }
    }

    private fun setOperator(operator: String) {
        if (currentOperator.isNotEmpty() && previousNumber.isNotEmpty()) {
            calculateResult() // Calcula el resultado de la operación anterior si ya hay un operador y número previo
        }
        previousNumber = currentNumber
        currentOperator = operator
        resetDisplay = true // La siguiente entrada numérica debe limpiar la pantalla
    }

    private fun calculateResult() {
        if (previousNumber.isEmpty() || currentOperator.isEmpty()) {
            return // No hay suficiente información para calcular
        }

        val num1 = previousNumber.toDoubleOrNull() ?: 0.0
        val num2 = currentNumber.toDoubleOrNull() ?: 0.0
        var result = 0.0

        when (currentOperator) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    currentNumber = "Error: Div por 0"
                    clearStateForError()
                    return
                }
            }
        }
        currentNumber = result.toString()
        previousNumber = ""
        currentOperator = ""
        resetDisplay = true // El siguiente número debe iniciar una nueva operación o limpiar la pantalla
    }

    private fun clearAll() {
        currentNumber = "0"
        previousNumber = ""
        currentOperator = ""
        resetDisplay = false
    }

    private fun clearStateForError() {
        previousNumber = ""
        currentOperator = ""
        resetDisplay = true
    }
}
