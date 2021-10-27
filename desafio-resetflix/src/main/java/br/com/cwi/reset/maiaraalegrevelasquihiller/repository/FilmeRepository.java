package br.com.cwi.reset.maiaraalegrevelasquihiller.repository;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {
}
