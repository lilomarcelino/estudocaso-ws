package net.unibave.formulario.resource;

import net.unibave.formulario.model.FormularioPergunta;
import net.unibave.formulario.service.FormularioPerguntaService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulario-pergunta")
public class FormularioPerguntaResource extends AbstractResource<FormularioPergunta, Long> {

  private final FormularioPerguntaService formularioPerguntaService;

  @Autowired
  public FormularioPerguntaResource(FormularioPerguntaService formularioPerguntaService) {
    super(formularioPerguntaService);
    this.formularioPerguntaService = formularioPerguntaService;
  }
}
