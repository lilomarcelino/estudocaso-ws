package net.unibave.formulario.model;

import net.unibave.formulario.enums.TipoAcessoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "grupo_acesso")
public class GrupoAcesso implements Serializable {
    private static final String SEQUENCE = "grupo_acesso_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_grupo")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tip_acesso")
    private TipoAcessoEnum tipoAcesso;

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

    public TipoAcessoEnum getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(TipoAcessoEnum tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoAcesso that = (GrupoAcesso) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GrupoAcesso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoAcesso=" + tipoAcesso +
                '}';
    }
}
