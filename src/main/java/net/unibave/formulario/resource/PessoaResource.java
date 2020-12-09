package net.unibave.formulario.resource;

import net.unibave.formulario.model.Pessoa;
import net.unibave.formulario.service.PessoaService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource extends AbstractResource<Pessoa, Long> {

  private final PessoaService pessoaService;

  @Autowired
  public PessoaResource(PessoaService pessoaService) {
    super(pessoaService);
    this.pessoaService = pessoaService;
  }
}
