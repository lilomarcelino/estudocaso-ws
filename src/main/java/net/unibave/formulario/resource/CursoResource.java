package net.unibave.formulario.resource;

import net.unibave.formulario.model.Curso;
import net.unibave.formulario.service.CursoService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoResource extends AbstractResource<Curso, Long> {

  private final CursoService cursoService;

  @Autowired
  public CursoResource(CursoService cursoService) {
    super(cursoService);
    this.cursoService = cursoService;
  }
}
