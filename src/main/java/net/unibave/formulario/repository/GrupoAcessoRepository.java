package net.unibave.formulario.repository;

import net.unibave.formulario.model.GrupoAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoAcessoRepository extends JpaRepository<GrupoAcesso, Long>, JpaSpecificationExecutor<GrupoAcesso> {
}
