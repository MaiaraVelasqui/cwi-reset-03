package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Estudio;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception{
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio>consultarEstudios(@RequestParam String filtroNome)throws Exception{
        return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping(path= "/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception{
        return this.estudioService.consultarEstudio(id);
    }



}
