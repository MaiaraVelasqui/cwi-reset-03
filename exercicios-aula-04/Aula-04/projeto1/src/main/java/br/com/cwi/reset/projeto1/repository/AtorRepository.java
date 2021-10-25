package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findByNome(String nome);
    List<Ator> findByNumeroOscars(Integer numeroOscars);
}
