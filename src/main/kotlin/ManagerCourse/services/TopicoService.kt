package ManagerCourses.services

import ManagerCourses.dto.TopicoDto
import ManagerCourses.dto.TopicoView
import org.springframework.stereotype.Service
import ManagerCourses.model.Curso
import ManagerCourses.model.Topico
import ManagerCourses.model.Usuario
import java.util.stream.Collectors


@Service
class TopicoService (
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
    ){

    fun listarTopicos(): List<TopicoView> {
        return topicos.stream().map { topico ->TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        ) }.collect(Collectors.toList())
    }

    fun getTopicoId(id: Long): TopicoView {
        val topico = topicos.stream().filter({topico -> topico.id == id}).findFirst().get()
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.dataCriacao,
            status = topico.status
        )
    }

    fun cadastrar(dto: TopicoDto) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.CursoId),
            autor = usuarioService.buscarPorId(dto.AutorId),
        ))

    }
}