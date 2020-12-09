package net.unibave.formulario.service;

import net.unibave.formulario.model.GrupoAcesso;
import net.unibave.formulario.repository.GrupoAcessoRepository;
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
public class GrupoAcessoService implements GenericService<GrupoAcesso, Long> {


  private GrupoAcessoRepository grupoAcessoRepository;

  @Autowired
  public GrupoAcessoService(GrupoAcessoRepository grupoAcessoRepository) {
    this.grupoAcessoRepository = grupoAcessoRepository;
  }

  @Override
  public Page<GrupoAcesso> findAll(Pageable pageable) {
    return grupoAcessoRepository.findAll(pageable);
  }

  @Override
  public Page<GrupoAcesso> findAll(Specification<GrupoAcesso> specification, Pageable pageable) {
    return grupoAcessoRepository.findAll(specification, pageable);
  }

  @Override
  public List<GrupoAcesso> findAll(Sort sort) {
    return grupoAcessoRepository.findAll(sort);
  }

  @Override
  public List<GrupoAcesso> findAll(Specification<GrupoAcesso> specification, Sort sort) {
    return grupoAcessoRepository.findAll(specification, sort);
  }

  @Override
  public GrupoAcesso save(GrupoAcesso entity) {
    return grupoAcessoRepository.save(entity);
  }

  @Override
  public Optional<GrupoAcesso> findById(Long id) {
    return grupoAcessoRepository.findById(id);
  }

  @Override
  public void delete(GrupoAcesso entity) {
    grupoAcessoRepository.delete(entity);
  }
}
