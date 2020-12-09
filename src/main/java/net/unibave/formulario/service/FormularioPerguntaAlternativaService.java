package net.unibave.formulario.service;

import net.unibave.formulario.model.FormularioPerguntaAlternativa;
import net.unibave.formulario.repository.FormularioPerguntaAlternativaRepository;
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
public class FormularioPerguntaAlternativaService implements GenericService<FormularioPerguntaAlternativa, Long> {


  private FormularioPerguntaAlternativaRepository formularioPerguntaAlternativaRepository;

  @Autowired
  public FormularioPerguntaAlternativaService(FormularioPerguntaAlternativaRepository formularioPerguntaAlternativaRepository) {
    this.formularioPerguntaAlternativaRepository = formularioPerguntaAlternativaRepository;
  }

  @Override
  public Page<FormularioPerguntaAlternativa> findAll(Pageable pageable) {
    return formularioPerguntaAlternativaRepository.findAll(pageable);
  }

  @Override
  public Page<FormularioPerguntaAlternativa> findAll(Specification<FormularioPerguntaAlternativa> specification, Pageable pageable) {
    return formularioPerguntaAlternativaRepository.findAll(specification, pageable);
  }

  @Override
  public List<FormularioPerguntaAlternativa> findAll(Sort sort) {
    return formularioPerguntaAlternativaRepository.findAll(sort);
  }

  @Override
  public List<FormularioPerguntaAlternativa> findAll(Specification<FormularioPerguntaAlternativa> specification, Sort sort) {
    return formularioPerguntaAlternativaRepository.findAll(specification, sort);
  }

  @Override
  public FormularioPerguntaAlternativa save(FormularioPerguntaAlternativa entity) {
    return formularioPerguntaAlternativaRepository.save(entity);
  }

  @Override
  public Optional<FormularioPerguntaAlternativa> findById(Long id) {
    return formularioPerguntaAlternativaRepository.findById(id);
  }

  @Override
  public void delete(FormularioPerguntaAlternativa entity) {
    formularioPerguntaAlternativaRepository.delete(entity);
  }
}
