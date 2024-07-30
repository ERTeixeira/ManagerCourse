package ManagerCourse.services

import ManagerCourse.mapper.TopicoFormMapper
import ManagerCourse.mapper.TopicoViewMapper
import ManagerCourse.dto.TopicoForm
import ManagerCourse.dto.TopicoView
import org.springframework.stereotype.Service
import ManagerCourse.model.Topico
import java.util.stream.Collectors


@Service
class TopicoService (
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
    ){

    fun listarTopicos(): List<TopicoView> {
        return topicos.stream().map {
            topico -> topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun getTopicoId(id: Long): TopicoView {
        val topico = topicos.stream().filter({topico -> topico.id == id}).findFirst().get()
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(dto: TopicoForm) {
        val topico = topicoFormMapper.map(dto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

    }
}