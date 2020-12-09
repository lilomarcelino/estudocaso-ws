package net.unibave.formulario.service;

import net.unibave.formulario.model.Login;
import net.unibave.formulario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    private final UsuarioService usuarioService;

    @Autowired
    public AuthService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario logar(Login login) {
        if (Objects.isNull(login) || Objects.isNull(login.getLogin()) || Objects.isNull(login.getSenha())) throw new RuntimeException("Dados Inválidos");
        return usuarioService.findByLoginAndSenha(login).orElseThrow(() ->  new RuntimeException("Usuário não encontrado"));
    }
}
