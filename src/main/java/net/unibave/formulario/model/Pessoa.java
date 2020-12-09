package net.unibave.formulario.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    private static final String SEQUENCE = "pessoa_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nom_pessoa")
    private String nome;

    @NotNull
    @Column(name = "cpf_pessoa")
    private String cpf;

    @NotNull
    @Column(name = "cod_univerdade")
    private String codigoUniversidade;

    @NotNull
    @Column(name = "des_email")
    private String email;

    @NotNull
    @Column(name = "des_telefone")
    private String telefone;

    @NotNull
    @Column(name = "tip_pessoa")
    private String tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_fase")
    private Fase fase;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dat_nascimento")
    private Date dataNascimento;

    @NotNull
    @Column(name = "flg_ativo")
    private boolean ativo;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodigoUniversidade() {
        return codigoUniversidade;
    }

    public void setCodigoUniversidade(String codigoUniversidade) {
        this.codigoUniversidade = codigoUniversidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return getId().equals(pessoa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", codigoUniversidade='" + codigoUniversidade + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fase=" + fase +
                ", curso=" + curso +
                ", dataNascimento=" + dataNascimento +
                ", ativo=" + ativo +
                '}';
    }
}
