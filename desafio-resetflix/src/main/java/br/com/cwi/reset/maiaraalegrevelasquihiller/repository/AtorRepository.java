package br.com.cwi.reset.maiaraalegrevelasquihiller.repository;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {
}
