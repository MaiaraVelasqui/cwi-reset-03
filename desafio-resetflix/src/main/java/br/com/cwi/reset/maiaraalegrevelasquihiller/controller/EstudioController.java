package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Estudio;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.DiretorService;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/estudios")
    public class EstudioController {
    private EstudioService estudioService;
    public EstudioController() {this.estudioService = new EstudioService(FakeDatabase.getInstance());}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception{
        this.estudioService.criarEstudio(estudioRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Estudio>consultarEstudios(@RequestParam String filtroNome)throws Exception{
        return this.estudioService.consultarEstudios(filtroNome);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception{
        return this.estudioService.consultarEstudio(id);
    }



}
