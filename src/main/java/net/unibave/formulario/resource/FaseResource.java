package net.unibave.formulario.resource;

import net.unibave.formulario.model.Fase;
import net.unibave.formulario.service.FaseService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fase")
public class FaseResource extends AbstractResource<Fase, Long> {

  private final FaseService faseService;

  @Autowired
  public FaseResource(FaseService faseService) {
    super(faseService);
    this.faseService = faseService;
  }
}
