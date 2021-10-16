package br.com.cwi.reset.primeiroprojetospring.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping ("/filme")

public class FilmeController {
    @GetMapping
    public Filme getFilme(){
        Diretor diretor = new Diretor ( "Cristopher Nollan", LocalDate.of(1980,5,22), Genero.MASCULINO,5);
        Filme nemo = new Filme("Procurando Nemo", "Um pai que procura seu filho", 90, 2006, 5.0,diretor);
        return nemo;
    }
}
