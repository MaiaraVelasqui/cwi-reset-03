package br.com.cwi.reset.maiaraalegrevelasquihiller.controller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.DiretorService;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
