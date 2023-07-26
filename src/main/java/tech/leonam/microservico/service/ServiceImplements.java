package tech.leonam.microservico.service;

import org.springframework.stereotype.Service;
import tech.leonam.microservico.model.Repository.RepositoryEntity;

@Service
public class ServiceImplements {
    private final RepositoryEntity repository;
    public ServiceImplements(RepositoryEntity repository) {
        this.repository = repository;
    }
    public RepositoryEntity getRepository() {
        return repository;
    }

}
