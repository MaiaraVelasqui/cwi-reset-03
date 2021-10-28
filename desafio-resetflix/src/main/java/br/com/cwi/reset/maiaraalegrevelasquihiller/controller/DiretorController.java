package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.DiretorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody @Valid DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping(path= "/em_atividade")
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listarDiretores(@RequestParam String filtroNome)throws Exception{
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Integer id)throws Exception{
        return this.diretorService.consultarDiretor(id);
    }

    @GetMapping
    public List<Diretor> listarDiretores() throws Exception{
        return this.diretorService.consultarDiretores();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarDiretor(@PathVariable Integer id, @Valid @RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.atualizarDiretor(id, diretorRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerDiretores(@PathVariable Integer id) throws Exception {
        this.diretorService.removerDiretores(id);
    }
}
