package net.unibave.formulario.repository;

import net.unibave.formulario.model.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRepository extends JpaRepository<Fase, Long>, JpaSpecificationExecutor<Fase> {
}
