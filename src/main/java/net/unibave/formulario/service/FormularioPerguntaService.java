package net.unibave.formulario.service;

import net.unibave.formulario.model.FormularioPergunta;
import net.unibave.formulario.repository.FormularioPerguntaRepository;
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
public class FormularioPerguntaService implements GenericService<FormularioPergunta, Long> {


  private FormularioPerguntaRepository formularioPerguntaRepository;

  @Autowired
  public FormularioPerguntaService(FormularioPerguntaRepository formularioPerguntaRepository) {
    this.formularioPerguntaRepository = formularioPerguntaRepository;
  }

  @Override
  public Page<FormularioPergunta> findAll(Pageable pageable) {
    return formularioPerguntaRepository.findAll(pageable);
  }

  @Override
  public Page<FormularioPergunta> findAll(Specification<FormularioPergunta> specification, Pageable pageable) {
    return formularioPerguntaRepository.findAll(specification, pageable);
  }

  @Override
  public List<FormularioPergunta> findAll(Sort sort) {
    return formularioPerguntaRepository.findAll(sort);
  }

  @Override
  public List<FormularioPergunta> findAll(Specification<FormularioPergunta> specification, Sort sort) {
    return formularioPerguntaRepository.findAll(specification, sort);
  }

  @Override
  public FormularioPergunta save(FormularioPergunta entity) {
    return formularioPerguntaRepository.save(entity);
  }

  @Override
  public Optional<FormularioPergunta> findById(Long id) {
    return formularioPerguntaRepository.findById(id);
  }

  @Override
  public void delete(FormularioPergunta entity) {
    formularioPerguntaRepository.delete(entity);
  }
}
