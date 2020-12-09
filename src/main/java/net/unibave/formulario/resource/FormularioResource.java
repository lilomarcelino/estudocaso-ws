package net.unibave.formulario.resource;

import net.unibave.formulario.model.Formulario;
import net.unibave.formulario.service.FormularioService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulario")
public class FormularioResource extends AbstractResource<Formulario, Long> {

  private final FormularioService formularioService;

  @Autowired
  public FormularioResource(FormularioService formularioService) {
    super(formularioService);
    this.formularioService = formularioService;
  }

  @GetMapping("totalRespostas/{idFormulario}/{idUsuario}")
  public ResponseEntity<Long> getById(@PathVariable("idFormulario") Long idFormulario,
                                      @PathVariable("idUsuario") Long idUsuario) {
    return ResponseEntity.ok().body(formularioService.totalRespostas(idFormulario, idUsuario));
  }
}
