import java.awt.BorderLayout
import java.awt.Font
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

fun crearYMostrarUI() {
    // 1. Crea la ventana principal
    val frame = JFrame("Calculadora")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(300, 400) // Damos un tamaño inicial a la ventana

    // El panel principal usará BorderLayout
    val panelPrincipal = frame.contentPane
    panelPrincipal.layout = BorderLayout()

    // 2. Crea la pantalla de la calculadora
    val pantalla = JTextField("0") // Texto inicial
    pantalla.isEditable = true // Para que no se pueda escribir con el teclado
    pantalla.horizontalAlignment = JTextField.RIGHT // Alinea el texto a la derecha
    pantalla.font = Font("Arial", Font.BOLD, 32) // Aumenta el tamaño de la fuente

    // Añade la pantalla en la parte de ARRIBA (NORTH)
    panelPrincipal.add(pantalla, BorderLayout.NORTH)

    val calculadoraLogica = CalculadoraLogica()


    // 3. Crea el panel para los botones con una cuadrícula (GridLayout)
    val panelBotones = JPanel()
    // GridLayout de 4 filas, 4 columnas, con 5px de separación horizontal y vertical
    panelBotones.layout = GridLayout(4, 4, 5, 5)

    // Lista de los textos de los botones
    val etiquetasBotones = arrayOf(
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "C", "0", "=", "+"
    )
    // Crea los botones y los añade al panel de botones
    for (etiqueta in etiquetasBotones) {
        val boton = JButton(etiqueta)
        boton.font = Font("Arial", Font.BOLD, 18)
        panelBotones.add(boton)
        boton.addActionListener {
            val textoBoton = (it.source as JButton).text // Obtiene el texto del botón presionado
            val nuevoTextoPantalla = calculadoraLogica.processInput(textoBoton) // Llama a la lógica
            pantalla.text = nuevoTextoPantalla // Actualiza la pantalla de la IU con el resultado de la lógica
        }
    }

    // Añade el panel de botones en el CENTRO
    panelPrincipal.add(panelBotones, BorderLayout.CENTER)

    // 4. Centra y hace visible la ventana
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}