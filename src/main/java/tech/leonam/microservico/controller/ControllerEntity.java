package tech.leonam.microservico.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.leonam.microservico.model.DTO.EntidadeDTO;
import tech.leonam.microservico.model.SanatizarDados;
import tech.leonam.microservico.service.ServiceImplements;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "*", maxAge = 30, methods = RequestMethod.POST)
@RequestMapping("/inserir")
public class ControllerEntity {
    private final ServiceImplements serviceImplements;

    public ControllerEntity(ServiceImplements serviceImplements) {
        this.serviceImplements = serviceImplements;
    }

    @PostMapping()
    public ResponseEntity<Object> inserirNoBancoDeDados(@RequestBody @Valid EntidadeDTO entidadeDTO, HttpServletRequest request) {
        try {
            CacheControl cacheControl = CacheControl.noStore();

            var entidadeDao = new SanatizarDados(entidadeDTO).limpar();

            var dateTime = ZonedDateTime.now(ZoneId.of("America/Belem"));
            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            var formatado = dateTime.format(formatter);
            System.out.println(formatado);
            entidadeDao.setDataEHora(formatado);

            serviceImplements.getRepository().save(entidadeDao);
            return ResponseEntity.ok().cacheControl(cacheControl).body("Salvo com Sucesso");
        } catch (IllegalArgumentException ex) {
            var ip = request.getRemoteAddr();
            System.out.println("Ip que fez merda: " + ip + " Erro: " + ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
