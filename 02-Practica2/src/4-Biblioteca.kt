/**
 * Biblioteca.kt
 * Sistema de gestión de biblioteca con Material (abstracta), Libro, Revista,
 * Usuario (data class), IBiblioteca y su implementación Biblioteca.
 */

// Clase Material (abstracta)
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("--- Detalles del Libro ---")
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numeroPaginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("--- Detalles de la Revista ---")
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles: MutableList<Material> = mutableListOf()
    private val materialesPrestados: MutableMap<Usuario, MutableList<Material>> = mutableMapOf()
    private val usuariosRegistrados: MutableList<Usuario> = mutableListOf()

    override fun registrarMaterial(material: Material) {
        if (materialesDisponibles.none { it.titulo == material.titulo && it.autor == material.autor }) {
            materialesDisponibles.add(material)
            println("Material '${material.titulo}' registrado exitosamente.")
        } else {
            println("El material '${material.titulo}' ya está registrado.")
        }
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuariosRegistrados.contains(usuario)) {
            usuariosRegistrados.add(usuario)
            println("Usuario ${usuario.nombre} ${usuario.apellido} registrado exitosamente.")
        } else {
            println("El usuario ${usuario.nombre} ${usuario.apellido} ya está registrado.")
        }
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        if (!usuariosRegistrados.contains(usuario)) {
            println("Error: El usuario ${usuario.nombre} ${usuario.apellido} no está registrado en la biblioteca.")
            return false
        }
        if (materialesDisponibles.remove(material)) {
            materialesPrestados.getOrPut(usuario) { mutableListOf() }.add(material)
            println("Material '${material.titulo}' prestado a ${usuario.nombre} ${usuario.apellido}.")
            return true
        } else {
            println("El material '${material.titulo}' no está disponible para préstamo.")
            return false
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        if (!usuariosRegistrados.contains(usuario)) {
            println("Error: El usuario ${usuario.nombre} ${usuario.apellido} no está registrado en la biblioteca.")
            return false
        }
        val materialesDelUsuario = materialesPrestados[usuario]
        if (materialesDelUsuario != null && materialesDelUsuario.remove(material)) {
            materialesDisponibles.add(material)
            println("Material '${material.titulo}' devuelto por ${usuario.nombre} ${usuario.apellido}.")
            return true
        } else {
            println("El usuario ${usuario.nombre} ${usuario.apellido} no tiene prestado el material '${material.titulo}'.")
            return false
        }
    }

    override fun mostrarMaterialesDisponibles() {
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles en la biblioteca.")
            return
        }
        println("\n--- Materiales Disponibles ---")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        if (!usuariosRegistrados.contains(usuario)) {
            println("Error: El usuario ${usuario.nombre} ${usuario.apellido} no está registrado en la biblioteca.")
            return
        }
        val materialesReservados = materialesPrestados[usuario]
        if (materialesReservados.isNullOrEmpty()) {
            println("El usuario ${usuario.nombre} ${usuario.apellido} no tiene materiales en préstamo.")
            return
        }
        println("\n--- Materiales en préstamo de ${usuario.nombre} ${usuario.apellido} ---")
        materialesReservados.forEach { it.mostrarDetalles() }
    }
}