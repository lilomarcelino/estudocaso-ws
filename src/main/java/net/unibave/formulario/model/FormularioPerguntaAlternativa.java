package net.unibave.formulario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "formulario_pergunta_alternativa")
public class FormularioPerguntaAlternativa {

    private static final String SEQUENCE = "formulario_pergunta_alternativa_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nom_pergunta_alternativa")
    private String nome;

    @NotNull
    @Column(name = "des_pergunta_alternativa")
    private String descricao;

    @NotNull
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_formulario_pergunta")
    private FormularioPergunta formularioPergunta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FormularioPergunta getFormularioPergunta() {
        return formularioPergunta;
    }

    public void setFormularioPergunta(FormularioPergunta formularioPergunta) {
        this.formularioPergunta = formularioPergunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormularioPerguntaAlternativa)) return false;
        FormularioPerguntaAlternativa that = (FormularioPerguntaAlternativa) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "FormularioPerguntaAlternativa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", formularioPergunta=" + formularioPergunta +
                '}';
    }
}
