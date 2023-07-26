package tech.leonam.microservico.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leonam.microservico.model.Entity.EntidadeDao;
@org.springframework.stereotype.Repository
public interface RepositoryEntity extends JpaRepository<EntidadeDao,Long> {}
