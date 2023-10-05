package tech.leonam.microservico.model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityDtoSave {
    @NotBlank(message = "Vazio")
    @Size(max = 100, message = "Nome: Não pode maior que 100")
    private String name;
    @NotBlank(message = "Vazio")
    @Size(min = 8, max = 20, message = "Número: Deve entrar entre 8 a 20 caracteres")
    private String numberPhone;
    @NotBlank(message = "Email: Vazio")
    @Email(message = "Email: Não é um Email")
    private String email;
    @NotBlank(message = "Assunto: Vazio")
    @Size(max = 255, message = "Assunto: Não pode maior que 255")
    private String topicConversation;

}
