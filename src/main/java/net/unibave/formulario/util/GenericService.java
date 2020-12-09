package net.unibave.formulario.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID extends Serializable> {
    Page<T> findAll(Pageable pageable);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    List<T> findAll(Sort sort);

    List<T> findAll(Specification<T> specification, Sort sort);

    T save(T entity);

    Optional<T> findById(ID id);

    void delete(T entity);
}
