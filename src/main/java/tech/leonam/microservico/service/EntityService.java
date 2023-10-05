package tech.leonam.microservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.leonam.microservico.model.DTO.EntityDtoReturn;
import tech.leonam.microservico.model.DTO.EntityDtoSave;
import tech.leonam.microservico.model.entity.Entity;
import tech.leonam.microservico.repository.RepositoryEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class EntityService {
    @Autowired
    private RepositoryEntity repository;

    public EntityDtoReturn save(EntityDtoSave entityDtoSave){
        var entity = entityDtoToEntity(entityDtoSave);
        entity.setDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        return entityToEntityDtoReturn(repository.save(entity));
    }

    public static Entity entityDtoToEntity(EntityDtoSave entityDtoSave) {
        var entity = new Entity();
        entity.setNumberPhone(normalizaNumero(entityDtoSave.getNumberPhone()));
        entity.setName(pascalCase(entityDtoSave.getName()));
        entity.setEmail(entityDtoSave.getEmail());
        entity.setTopicConversation(entityDtoSave.getTopicConversation());

        return entity;
    }

    public static EntityDtoReturn entityToEntityDtoReturn(Entity entity){
        var entityReturn = new EntityDtoReturn();
        entityReturn.setId(entity.getId());
        entityReturn.setName(entity.getName());
        entityReturn.setEmail(entity.getEmail());
        entityReturn.setDate(entity.getDate());
        entityReturn.setNumberPhone(entity.getNumberPhone());
        entityReturn.setTopicConversation(entity.getTopicConversation());

        return entityReturn;
    }

    public static String pascalCase(String nome) {
        var caracteres = nome.trim().toLowerCase().toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);

        for (var i = 1; i < caracteres.length; i++) {
            if (caracteres[i] == ' '){
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
            }
            if(!Character.isLetter(caracteres[i]) && !(caracteres[i] == ' ')){
                throw new IllegalArgumentException("No campo nome só são aceitas letras.");
            }
        }
        return String.valueOf(caracteres);
    }

    public static String normalizaNumero(String numero) {
        var arrayDecaracteres = numero.trim().toCharArray();
        for (char c : arrayDecaracteres) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("No campo número só são aceitos números.");
            }
        }
        return String.valueOf(arrayDecaracteres);
    }

}
