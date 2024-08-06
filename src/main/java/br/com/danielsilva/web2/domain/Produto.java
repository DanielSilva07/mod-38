package br.com.danielsilva.web2.domain;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="produto_sq")
    private Long id;

    @Column(name = "CODIGO" , length = 10 , nullable = false , unique = true)
    private String codigo;

    @Column(name = "NOME" , length = 50 , nullable = false )
    private String nome;

    @Column(name = "DESCRIPTION" , length = 50 , nullable = false )
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fregistro;


    private String email;



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getFregistro() {
        return fregistro;
    }

    public void setFregistro(Date fregistro) {
        this.fregistro = fregistro;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
