package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    private List<Pet> pets = new ArrayList<>();

    public Pet findByNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    public void save(Pet pet){
        pets.add(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void remove(Pet pet) {
        pets.remove(pet);
    }

    public void add(Pet pet) {
        pets.add(pet);
    }
}
