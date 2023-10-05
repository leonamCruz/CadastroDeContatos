package tech.leonam.microservico.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.leonam.microservico.model.DTO.EntityDtoReturn;
import tech.leonam.microservico.model.DTO.EntityDtoSave;
import tech.leonam.microservico.service.EntityService;

@RestController
@CrossOrigin(origins = "*", maxAge = 30, methods = RequestMethod.POST)
@RequestMapping("/entity")
public class EntityController {

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping()
    public ResponseEntity<EntityDtoReturn> save(@RequestBody @Valid EntityDtoSave entityDtoSave, HttpServletRequest request) {
        var entitySaved = entityService.save(entityDtoSave);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entitySaved.getId()).toUri();

        return ResponseEntity.created(uri).body(entitySaved);
    }

}
