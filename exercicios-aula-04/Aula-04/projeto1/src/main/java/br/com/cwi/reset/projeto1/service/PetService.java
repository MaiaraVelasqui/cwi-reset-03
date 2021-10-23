package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PetService {
    private PetRepository repository = new PetRepository();

    public Pet salvar(Pet pet) {
        repository.save(pet);
        return pet;
    }

    public Pet buscarPetPeloNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Pet> getPets() {
        return repository.getPets();
    }

    public void deletarPet(@PathVariable String nome) {
        Pet pet =repository.findByNome(nome);
        if (pet != null) {
            repository.remove(pet);
        }
    }

    public void atualizarPet(@RequestBody Pet pet) {
        Pet petCadastrado = repository.findByNome(pet.getNome());

        if (petCadastrado != null) {
            repository.remove(petCadastrado);
            repository.add(pet);
        }
    }
}
