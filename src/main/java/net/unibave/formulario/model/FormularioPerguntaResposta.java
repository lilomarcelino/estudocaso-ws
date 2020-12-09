package net.unibave.formulario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "formulario_pergunta_resposta")
public class FormularioPerguntaResposta {


    private static final String SEQUENCE = "formulario_pergunta_resposta_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "des_resposta")
    private String descricao;

    @NotNull
    @Column(name = "des_situacao")
    private String situacao;

    @NotNull
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_formulario_pergunta")
    private FormularioPergunta formularioPergunta;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public FormularioPergunta getFormularioPergunta() {
        return formularioPergunta;
    }

    public void setFormularioPergunta(FormularioPergunta formularioPergunta) {
        this.formularioPergunta = formularioPergunta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormularioPerguntaResposta)) return false;
        FormularioPerguntaResposta that = (FormularioPerguntaResposta) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "FormularioPerguntaResposta{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", situacao='" + situacao + '\'' +
                ", formularioPergunta=" + formularioPergunta +
                ", pessoa=" + pessoa +
                '}';
    }
}
