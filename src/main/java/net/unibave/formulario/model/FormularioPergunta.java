package net.unibave.formulario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.unibave.formulario.enums.TipoPerguntaEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "formulario_pergunta")
public class FormularioPergunta {

    private static final String SEQUENCE = "formulario_pergunta_id_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nom_pergunta")
    private String nome;

    @NotNull
    @Column(name = "des_pergunta")
    private String descricao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tip_pergunta")
    private TipoPerguntaEnum tipo;

    @NotNull
    @Column(name = "flg_multipla_escolha")
    private boolean multiplaEscolha;

    @NotNull
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_formulario")
    private Formulario formulario;

    @JsonManagedReference
    @OneToMany(mappedBy = "formularioPergunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FormularioPerguntaAlternativa> alternativas;

    @JsonManagedReference
    @OneToMany(mappedBy = "formularioPergunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FormularioPerguntaResposta> respostas;

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

    public TipoPerguntaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoPerguntaEnum tipo) {
        this.tipo = tipo;
    }

    public boolean isMultiplaEscolha() {
        return multiplaEscolha;
    }

    public void setMultiplaEscolha(boolean multiplaEscolha) {
        this.multiplaEscolha = multiplaEscolha;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public List<FormularioPerguntaAlternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<FormularioPerguntaAlternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public List<FormularioPerguntaResposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<FormularioPerguntaResposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormularioPergunta)) return false;
        FormularioPergunta that = (FormularioPergunta) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "FormularioPergunta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", multiplaEscolha=" + multiplaEscolha +
                ", formulario=" + formulario +
                ", alternativas=" + alternativas +
                ", respostas=" + respostas +
                '}';
    }
}
