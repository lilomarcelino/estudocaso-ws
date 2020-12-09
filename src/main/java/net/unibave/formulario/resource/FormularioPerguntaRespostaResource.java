package net.unibave.formulario.resource;

import net.unibave.formulario.model.FormularioPerguntaResposta;
import net.unibave.formulario.service.FormularioPerguntaRespostaService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulario-pergunta-resposta")
public class FormularioPerguntaRespostaResource extends AbstractResource<FormularioPerguntaResposta, Long> {

  private final FormularioPerguntaRespostaService formularioPerguntaRespostaService;

  @Autowired
  public FormularioPerguntaRespostaResource(FormularioPerguntaRespostaService formularioPerguntaRespostaService) {
    super(formularioPerguntaRespostaService);
    this.formularioPerguntaRespostaService = formularioPerguntaRespostaService;
  }
}
