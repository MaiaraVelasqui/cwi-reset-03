package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {
    @Autowired
    private AtorRepository repository;

    public Ator buscarPeloNome(String nome) throws AtorNaoExistenteException {
        Ator ator = repository.findByNome(nome);

        if (ator == null) {
            throw new AtorNaoExistenteException("Ator com o nome  " + nome + " não existe");
        }

        return ator;
    }

    public Ator salvar(Ator ator) throws AtorJaExistenteException {
        Ator atorJaCadastrado = repository.findByNome(ator.getNome());

        if (atorJaCadastrado != null) {
            throw new AtorJaExistenteException("Ator com o nome " + ator.getNome() + " já existe");
        }

        return repository.save(ator);
    }

    public void delete(String nome) throws AtorNaoExistenteException {
        Ator ator = repository.findByNome(nome);

        if (ator == null) {
            throw new AtorNaoExistenteException("Ator com o nome " + nome + " não existe");
        }

        repository.delete(ator);
    }

    public List<Ator> buscarPorNumeroDeOscar(Integer numeroOscars) {
        return repository.findByNumeroOscars(numeroOscars);

    }


}
