package ManagerCourses.dto

data class TopicoForm (
    val titulo: String,
    val mensagem: String,
    val CursoId: Long,
    val AutorId: Long
)
