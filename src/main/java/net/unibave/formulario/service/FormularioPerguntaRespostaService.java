package net.unibave.formulario.service;

import net.unibave.formulario.model.FormularioPerguntaResposta;
import net.unibave.formulario.repository.FormularioPerguntaRespostaRepository;
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
public class FormularioPerguntaRespostaService implements GenericService<FormularioPerguntaResposta, Long> {


  private FormularioPerguntaRespostaRepository formularioPerguntaRespostaRepository;

  @Autowired
  public FormularioPerguntaRespostaService(FormularioPerguntaRespostaRepository formularioPerguntaRespostaRepository) {
    this.formularioPerguntaRespostaRepository = formularioPerguntaRespostaRepository;
  }

  @Override
  public Page<FormularioPerguntaResposta> findAll(Pageable pageable) {
    return formularioPerguntaRespostaRepository.findAll(pageable);
  }

  @Override
  public Page<FormularioPerguntaResposta> findAll(Specification<FormularioPerguntaResposta> specification, Pageable pageable) {
    return formularioPerguntaRespostaRepository.findAll(specification, pageable);
  }

  @Override
  public List<FormularioPerguntaResposta> findAll(Sort sort) {
    return formularioPerguntaRespostaRepository.findAll(sort);
  }

  @Override
  public List<FormularioPerguntaResposta> findAll(Specification<FormularioPerguntaResposta> specification, Sort sort) {
    return formularioPerguntaRespostaRepository.findAll(specification, sort);
  }

  @Override
  public FormularioPerguntaResposta save(FormularioPerguntaResposta entity) {
    return formularioPerguntaRespostaRepository.save(entity);
  }

  @Override
  public Optional<FormularioPerguntaResposta> findById(Long id) {
    return formularioPerguntaRespostaRepository.findById(id);
  }

  @Override
  public void delete(FormularioPerguntaResposta entity) {
    formularioPerguntaRespostaRepository.delete(entity);
  }
}
