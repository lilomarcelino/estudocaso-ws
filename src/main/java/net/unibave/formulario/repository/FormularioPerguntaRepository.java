package net.unibave.formulario.repository;

import net.unibave.formulario.model.FormularioPergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioPerguntaRepository extends JpaRepository<FormularioPergunta, Long>, JpaSpecificationExecutor<FormularioPergunta> {
}
