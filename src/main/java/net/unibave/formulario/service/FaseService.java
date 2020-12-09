package net.unibave.formulario.service;

import net.unibave.formulario.model.Fase;
import net.unibave.formulario.repository.FaseRepository;
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
public class FaseService implements GenericService<Fase, Long> {

  private FaseRepository faseRepository;

  @Autowired
  public FaseService(FaseRepository faseRepository) {
    this.faseRepository = faseRepository;
  }

  @Override
  public Page<Fase> findAll(Pageable pageable) {
    return faseRepository.findAll(pageable);
  }

  @Override
  public Page<Fase> findAll(Specification<Fase> specification, Pageable pageable) {
    return faseRepository.findAll(specification, pageable);
  }

  @Override
  public List<Fase> findAll(Sort sort) {
    return faseRepository.findAll(sort);
  }

  @Override
  public List<Fase> findAll(Specification<Fase> specification, Sort sort) {
    return faseRepository.findAll(specification, sort);
  }

  @Override
  public Fase save(Fase entity) {
    return faseRepository.save(entity);
  }

  @Override
  public Optional<Fase> findById(Long id) {
    return faseRepository.findById(id);
  }

  @Override
  public void delete(Fase entity) {
    faseRepository.delete(entity);
  }
}
