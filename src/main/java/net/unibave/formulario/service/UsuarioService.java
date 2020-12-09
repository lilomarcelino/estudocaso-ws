package net.unibave.formulario.service;

import net.unibave.formulario.model.Login;
import net.unibave.formulario.model.Usuario;
import net.unibave.formulario.repository.UsuarioRepository;
import net.unibave.formulario.util.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements GenericService<Usuario, Long> {

  private UsuarioRepository usuarioRepository;

  @Autowired
  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public Page<Usuario> findAll(Pageable pageable) {
    return usuarioRepository.findAll(pageable);
  }

  @Override
  public Page<Usuario> findAll(Specification<Usuario> specification, Pageable pageable) {
    return usuarioRepository.findAll(specification, pageable);
  }

  @Override
  public List<Usuario> findAll(Sort sort) {
    return usuarioRepository.findAll(sort);
  }

  @Override
  public List<Usuario> findAll(Specification<Usuario> specification, Sort sort) {
    return usuarioRepository.findAll(specification, sort);
  }

  @Override
  public Usuario save(Usuario entity) {
    return usuarioRepository.save(entity);
  }

  @Override
  public Optional<Usuario> findById(Long id) {
    return usuarioRepository.findById(id);
  }

  @Override
  public void delete(Usuario entity) {
    usuarioRepository.delete(entity);
  }

  public Optional<Usuario> findByLoginAndSenha(Login login) {
    return this.usuarioRepository.findByLoginAndSenha(login.getLogin(), login.getSenha());
  }
}
