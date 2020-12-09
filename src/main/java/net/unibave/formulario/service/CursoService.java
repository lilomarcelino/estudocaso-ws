package net.unibave.formulario.service;

import net.unibave.formulario.model.Curso;
import net.unibave.formulario.repository.CursoRepository;
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
public class CursoService implements GenericService<Curso, Long> {

  private CursoRepository cursoRepository;

  @Autowired
  public CursoService(CursoRepository cursoRepository) {
    this.cursoRepository = cursoRepository;
  }

  @Override
  public Page<Curso> findAll(Pageable pageable) {
    return cursoRepository.findAll(pageable);
  }

  @Override
  public Page<Curso> findAll(Specification<Curso> specification, Pageable pageable) {
    return cursoRepository.findAll(specification, pageable);
  }

  @Override
  public List<Curso> findAll(Sort sort) {
    return cursoRepository.findAll(sort);
  }

  @Override
  public List<Curso> findAll(Specification<Curso> specification, Sort sort) {
    return cursoRepository.findAll(specification, sort);
  }

  @Override
  public Curso save(Curso entity) {
    return cursoRepository.save(entity);
  }

  @Override
  public Optional<Curso> findById(Long id) {
    return cursoRepository.findById(id);
  }

  @Override
  public void delete(Curso entity) {
    cursoRepository.delete(entity);
  }
}
