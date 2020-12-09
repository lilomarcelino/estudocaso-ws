package net.unibave.formulario.service;

import net.unibave.formulario.model.Formulario;
import net.unibave.formulario.repository.FormularioPerguntaRepository;
import net.unibave.formulario.repository.FormularioRepository;
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
public class FormularioService implements GenericService<Formulario, Long> {


  private FormularioRepository formularioRepository;

  @Autowired
  public FormularioService(FormularioRepository formularioRepository) {
    this.formularioRepository = formularioRepository;
  }

  @Override
  public Page<Formulario> findAll(Pageable pageable) {
    return formularioRepository.findAll(pageable);
  }

  @Override
  public Page<Formulario> findAll(Specification<Formulario> specification, Pageable pageable) {
    return formularioRepository.findAll(specification, pageable);
  }

  @Override
  public List<Formulario> findAll(Sort sort) {
    return formularioRepository.findAll(sort);
  }

  @Override
  public List<Formulario> findAll(Specification<Formulario> specification, Sort sort) {
    return formularioRepository.findAll(specification, sort);
  }

  @Override
  public Formulario save(Formulario entity) {
    return formularioRepository.save(entity);
  }

  @Override
  public Optional<Formulario> findById(Long id) {
    return formularioRepository.findById(id);
  }

  @Override
  public void delete(Formulario entity) {
    formularioRepository.delete(entity);
  }

  public Long totalRespostas(Long idFormulario, Long idUsuario) {
    return formularioRepository.totalRespostas(idFormulario, idUsuario);
  }
}
