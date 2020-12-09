package net.unibave.formulario.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "formulario")
public class Formulario {

    private static final String SEQUENCE = "formulario_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nom_formulario")
    private String nome;

    @NotNull
    @Column(name = "des_formulario")
    private String descricao;

    @NotNull
    @Column(name = "des_situacao")
    private String situacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dat_inicio")
    private Date dataInicio;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dat_fim")
    private Date dataFim;

    @NotNull
    @Column(name = "flg_ativo")
    private Boolean ativo;

    @NotNull
    @JsonManagedReference
    @OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FormularioPergunta> perguntas;

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<FormularioPergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<FormularioPergunta> perguntas) {
        this.perguntas = perguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formulario)) return false;
        Formulario that = (Formulario) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", situacao='" + situacao + '\'' +
                ", pessoa=" + pessoa +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", ativo=" + ativo +
                ", perguntas=" + perguntas +
                '}';
    }
}
