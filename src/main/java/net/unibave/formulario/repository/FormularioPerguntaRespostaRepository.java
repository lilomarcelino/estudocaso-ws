package net.unibave.formulario.repository;

import net.unibave.formulario.model.FormularioPerguntaResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioPerguntaRespostaRepository extends JpaRepository<FormularioPerguntaResposta, Long>, JpaSpecificationExecutor<FormularioPerguntaResposta> {
}
