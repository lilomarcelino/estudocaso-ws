package net.unibave.formulario.resource;

import net.unibave.formulario.model.GrupoAcesso;
import net.unibave.formulario.service.GrupoAcessoService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo-acesso")
public class GrupoAcessoResource extends AbstractResource<GrupoAcesso, Long> {

  private final GrupoAcessoService grupoAcessoService;

  @Autowired
  public GrupoAcessoResource(GrupoAcessoService grupoAcessoService) {
    super(grupoAcessoService);
    this.grupoAcessoService = grupoAcessoService;
  }
}
