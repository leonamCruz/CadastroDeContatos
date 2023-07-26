package tech.leonam.microservico.model.Entity;

import jakarta.persistence.*;

@Entity
public class EntidadeDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String nome;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String numero;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4", nullable = false)
    private String assunto;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String dataEHora;

    public String getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(String dataEHora) {
        this.dataEHora = dataEHora;
    }

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
