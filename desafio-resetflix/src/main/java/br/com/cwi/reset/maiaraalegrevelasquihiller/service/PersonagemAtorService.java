package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.repository.PersonagemAtorRepository;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.PersonagemRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.AtorPersonagemRepetidoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.PersonagemAtor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.PersonagemValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonagemAtorService {
    
    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;
    
    @Autowired
    private AtorService atorService;

    public PersonagemAtor cadastrarPersonagemAtor(PersonagemRequest personagemRequest) throws Exception {
        new PersonagemValidacao().accept(personagemRequest);

        final Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());

        final PersonagemAtor personagemAtor = new PersonagemAtor(ator, personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());

        personagemAtorRepository.save(personagemAtor);

        return personagemAtor;
    }

    public List<PersonagemAtor> consultarPersonagemAtor(String nome) throws Exception {
        return (List<PersonagemAtor>) personagemAtorRepository.findAll();
    }

    private void validarPersonagensAtoresFilme(final List<PersonagemRequest> personagens) throws Exception {

        final Set<PersonagemRequest> personagemRequestSet = new HashSet<>();

        for (PersonagemRequest personagemRequest : personagens) {
            new PersonagemValidacao().accept(personagemRequest);

            /**
             * A linha: "if (personagemRequestSet.contains(personagemRequest))"
             *
             * Cai na implementação do Set abaixo
             * Implementação macro
             * https://docs.oracle.com/javase/7/docs/api/java/util/Set.html#contains(java.lang.Object)
             *
             * Que por sua vez chama o equals da classe da chave
             * Na prática:
             * PersonagemRequest.equals(PersonagemRequest);
             * {@link br.com.cwi.reset.josealencar.request.PersonagemRequest#equals(Object)}
             */
            if (personagemRequestSet.contains(personagemRequest)) {
                throw new AtorPersonagemRepetidoException("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
            } else {
                personagemRequestSet.add(personagemRequest);
            }
        }
    }

    public List<PersonagemAtor> cadastrarPersonagensFilme(final List<PersonagemRequest> personagens) throws Exception {
        validarPersonagensAtoresFilme(personagens);

        final List<PersonagemAtor> personagensAtores = new ArrayList<>();

        for (PersonagemRequest request : personagens) {
            personagensAtores.add(cadastrarPersonagemAtor(request));
        }

        return personagensAtores;
    }
 }
