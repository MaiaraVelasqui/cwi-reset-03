package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService service = new PetService();

    @GetMapping
    public List<Pet> getPets() {
        return service.getPets();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getById(@PathVariable String nome) {
        Pet pet = service.buscarPetPeloNome(nome);

        if (pet == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pet);
    }



    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) {
        service.salvar(pet);
        return pet;
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) {
       service.atualizarPet(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) {
        service.deletarPet(nome);
    }

}
