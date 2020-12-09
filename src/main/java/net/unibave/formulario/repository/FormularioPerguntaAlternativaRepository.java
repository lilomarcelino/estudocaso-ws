package net.unibave.formulario.repository;

import net.unibave.formulario.model.FormularioPerguntaAlternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioPerguntaAlternativaRepository extends JpaRepository<FormularioPerguntaAlternativa, Long>, JpaSpecificationExecutor<FormularioPerguntaAlternativa> {
}
