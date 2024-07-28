package ManagerCourses.services

import ManagerCourses.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Curso",
            categoria = "Categoria",
        )
        cursos = listOf(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { curso -> curso.id == id }.findFirst().get()
    }
}
