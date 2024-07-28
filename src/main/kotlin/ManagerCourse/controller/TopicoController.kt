package ManagerCourse.controller

import ManagerCourses.dto.TopicoDto
import ManagerCourses.dto.TopicoView
import ManagerCourses.services.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ManagerCourses.model.Topico
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listarTopicos (): List<TopicoView> {
        return service.listarTopicos()
    }

    @GetMapping("/{id}")
    fun getTopicoId(@PathVariable id: Long) : TopicoView {
        return service.getTopicoId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody dto: TopicoDto) {
       service.cadastrar(dto)
    }
}