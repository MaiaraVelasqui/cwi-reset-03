package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Filme;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.EstudioService;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
        private FilmeService filmeService;
        public FilmeController() {this.filmeService = new FilmeService(FakeDatabase.getInstance());}

@ResponseStatus(HttpStatus.CREATED)
@PostMapping
        public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
    this.filmeService.criarFilme(filmeRequest);
}
@ResponseStatus(HttpStatus.OK)
@GetMapping
    public List<Filme> consultarFilmes(@RequestParam String nomeFilme, @RequestParam String nomeDiretor,@RequestParam String nomePersonagem,@RequestParam String nomeAtor){
        this.filmeService
}


}
