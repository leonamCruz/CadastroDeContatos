package tech.leonam.microservico.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EntityDtoReturn {
    private long id;
    private LocalDateTime date;
    private String name;
    private String numberPhone;
    private String email;
    private String topicConversation;
}
