package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {

    private static List<Pet> pets = new ArrayList<>();

    public Pet buscarPeloNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    public Pet salvar(Pet pet) {
        pets.add(pet);
        return pet;
    }

    public void deletar(Pet pet) {
        pets.remove(pet);
    }

    public Pet atualizar(Pet pet) {
        Pet petCadastrado = buscarPeloNome(pet.getNome());

        if (petCadastrado != null) {
            pets.remove(petCadastrado);
            pets.add(pet);
            return pet;
        } else {
            return null;
        }
    }

    public List<Pet> listarTodos() {
        return pets;
    }

    @Override
    public <S extends Pet> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Pet> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Pet> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Pet> findAll() {
        return null;
    }

    @Override
    public Iterable<Pet> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Pet entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pet> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
