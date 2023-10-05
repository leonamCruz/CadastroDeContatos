package tech.leonam.microservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leonam.microservico.model.entity.Entity;
@org.springframework.stereotype.Repository
public interface RepositoryEntity extends JpaRepository<Entity,Long> {}
