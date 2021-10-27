package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Filme;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarFilme(@RequestBody @Valid FilmeRequest filmeRequest) throws Exception {
    this.filmeService.criarFilme(filmeRequest);
}
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Filme> consultarFilmes(@RequestParam String nomeFilme,
                                       @RequestParam String nomeDiretor,
                                       @RequestParam String nomePersonagem,
                                       @RequestParam String nomeAtor) throws Exception {
    return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
}


}
