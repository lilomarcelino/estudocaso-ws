package net.unibave.formulario.resource;

import net.unibave.formulario.model.Login;
import net.unibave.formulario.model.Usuario;
import net.unibave.formulario.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    private final AuthService authService;

    @Autowired
    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Login login) {
        return ResponseEntity.ok(authService.logar(login));
    }
}
