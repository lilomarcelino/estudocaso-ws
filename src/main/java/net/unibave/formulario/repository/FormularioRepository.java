package net.unibave.formulario.repository;

import net.unibave.formulario.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>, JpaSpecificationExecutor<Formulario> {
  @Query(nativeQuery = true,
          value = "select count(formulario_pergunta_resposta) " +
                  " from formulario join formulario_pergunta ON formulario_pergunta.id_formulario = formulario.id " +
                  "                 join formulario_pergunta_resposta  ON formulario_pergunta_resposta.id_formulario_pergunta = formulario_pergunta.id " +
                  "where formulario.id = :idFormulario" +
                  "  and formulario_pergunta_resposta.id_pessoa = :idPessoa")
  Long totalRespostas(@Param("idFormulario") Long idFormulario, @Param("idPessoa") Long idPessoa);
}
