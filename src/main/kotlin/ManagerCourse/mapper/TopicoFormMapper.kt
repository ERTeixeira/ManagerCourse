package ManagerCourse.mapper

import ManagerCourse.dto.TopicoForm
import ManagerCourse.model.Topico
import ManagerCourse.services.CursoService
import ManagerCourse.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<TopicoForm, Topico> {

    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.CursoId),
            autor = usuarioService.buscarPorId(t.AutorId),
        )
    }

}
