package tech.leonam.microservico.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class EntidadeDTO {
    @NotBlank(message = "Vazio")
    @Size(max = 100, message = "Nome: Não pode maior que 100")
    private String nome;
    @NotBlank(message = "Vazio")
    @Size(min = 8, max = 20, message = "Número: Deve entrar entre 8 a 20 caracteres")
    private String numero;
    @NotBlank(message = "Email: Vazio")
    @Email(message = "Email: Não é um Email")
    private String email;
    @NotBlank(message = "Assunto: Vazio")
    @Size(max = 255, message = "Assunto: Não pode maior que 255")
    private String assunto;

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
