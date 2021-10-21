package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.DiretorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/diretores")
public class DiretorController {
    private DiretorService diretorService;

    public DiretorController() {this.diretorService = new DiretorService(FakeDatabase.getInstance());}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listarDiretores(@RequestParam String filtroNome)throws Exception{
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Integer id)throws Exception{
        return this.diretorService.consultarDiretor(id);
    }


}
