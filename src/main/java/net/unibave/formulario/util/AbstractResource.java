package net.unibave.formulario.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractResource<T, ID extends Serializable> {
    private final GenericService<T, ID> service;

    protected AbstractResource(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public Page<T> getAll(Pageable pageable, @RequestParam(name = "search", required = false) String search) {
        if (Objects.isNull(search)) {
            return service.findAll(pageable);
        } else {
            List<SearchCriteria> params = GenericFiltersExtract.searchList(search);
            Specification<T> specification = GenericSpecification.findAllByEspecification(params);
            return service.findAll(specification, pageable);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable("id") ID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable("id") ID id, @RequestBody T body) {
        return service.findById(id)
                .map(entity -> {
                    BeanUtils.copyProperties(body, entity);
                    return entity;
                })
                .map(service::save)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<T> partialUpdate(@PathVariable("id") ID id, @RequestBody T body) {
        return service.findById(id)
                .map(entity -> {
                    BeanUtils.copyProperties(body, entity, returnIgnoreProperties(body));
                    return entity;
                })
                .map(service::save)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") ID id) {
        return service.findById(id)
                .map(entity -> {
                    service.delete(entity);
                    return entity;
                })
                .map(t -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    private String[] returnIgnoreProperties(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set emptyNames = new HashSet();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (Objects.isNull(srcValue) || pd.getName().equalsIgnoreCase("id")) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }
}