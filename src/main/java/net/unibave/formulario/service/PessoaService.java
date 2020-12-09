package net.unibave.formulario.service;


import net.unibave.formulario.model.Pessoa;
import net.unibave.formulario.repository.PessoaRepository;
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
public class PessoaService implements GenericService<Pessoa, Long> {


  private PessoaRepository pessoaRepository;

  @Autowired
  public PessoaService(PessoaRepository pessoaRepository) {
    this.pessoaRepository = pessoaRepository;
  }

  @Override
  public Page<Pessoa> findAll(Pageable pageable) {
    return pessoaRepository.findAll(pageable);
  }

  @Override
  public Page<Pessoa> findAll(Specification<Pessoa> specification, Pageable pageable) {
    return pessoaRepository.findAll(specification, pageable);
  }

  @Override
  public List<Pessoa> findAll(Sort sort) {
    return pessoaRepository.findAll(sort);
  }

  @Override
  public List<Pessoa> findAll(Specification<Pessoa> specification, Sort sort) {
    return pessoaRepository.findAll(specification, sort);
  }

  @Override
  public Pessoa save(Pessoa entity) {
    return pessoaRepository.save(entity);
  }

  @Override
  public Optional<Pessoa> findById(Long id) {
    return pessoaRepository.findById(id);
  }

  @Override
  public void delete(Pessoa entity) {
    pessoaRepository.delete(entity);
  }
}
