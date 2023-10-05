package tech.leonam.microservico.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@jakarta.persistence.Entity
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String numberPhone;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4", nullable = false)
    private String topicConversation;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private LocalDateTime date;
}
