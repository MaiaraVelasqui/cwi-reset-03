package br.com.cwi.reset.maiaraalegrevelasquihiller.repository;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor,Integer> {
}
