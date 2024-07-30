package ManagerCourse.services

import ManagerCourse.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
            id = 1,
            nome = "Erick",
            email = "erick@gmail.com",
        )
        usuarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { usuario -> usuario.id == id }.findFirst().get()
    }
}
