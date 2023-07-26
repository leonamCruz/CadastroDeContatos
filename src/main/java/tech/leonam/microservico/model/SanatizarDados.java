package tech.leonam.microservico.model;

import jakarta.validation.Valid;
import tech.leonam.microservico.model.DTO.EntidadeDTO;
import tech.leonam.microservico.model.Entity.EntidadeDao;

public class SanatizarDados {
    private EntidadeDTO entidadeDTO;

    public SanatizarDados(@Valid EntidadeDTO entidadeDTO) {
        this.entidadeDTO = entidadeDTO;
    }

    public EntidadeDao limpar() {
        var entidadeDao = new EntidadeDao();
        entidadeDao.setNumero(normalizaNumero(entidadeDTO.getNumero()));
        entidadeDao.setNome(pascalCase(entidadeDTO.getNome()));
        entidadeDao.setEmail(entidadeDTO.getEmail());
        entidadeDao.setAssunto(entidadeDTO.getAssunto());

        return entidadeDao;
    }

    public String pascalCase(String nome) {
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

    public String normalizaNumero(String numero) {
        var arrayDecaracteres = numero.trim().toCharArray();
        for (char c : arrayDecaracteres) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("No campo número só são aceitos números.");
            }
        }
        return String.valueOf(arrayDecaracteres);
    }
}
