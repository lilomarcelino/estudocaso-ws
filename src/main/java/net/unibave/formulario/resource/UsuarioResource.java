package net.unibave.formulario.resource;

import net.unibave.formulario.model.Usuario;
import net.unibave.formulario.service.UsuarioService;
import net.unibave.formulario.util.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource extends AbstractResource<Usuario, Long> {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioResource(UsuarioService usuarioService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
    }
}
