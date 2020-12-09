package net.unibave.formulario.resource;

import net.unibave.formulario.model.FormularioPerguntaAlternativa;
import net.unibave.formulario.service.FormularioPerguntaAlternativaService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulario-pergunta-alternativa")
public class FormularioPerguntaAlternativaResource extends AbstractResource<FormularioPerguntaAlternativa, Long> {

  private final FormularioPerguntaAlternativaService formularioPerguntaAlternativaService;

  @Autowired
  public FormularioPerguntaAlternativaResource(FormularioPerguntaAlternativaService formularioPerguntaAlternativaService) {
    super(formularioPerguntaAlternativaService);
    this.formularioPerguntaAlternativaService = formularioPerguntaAlternativaService;
  }
}
