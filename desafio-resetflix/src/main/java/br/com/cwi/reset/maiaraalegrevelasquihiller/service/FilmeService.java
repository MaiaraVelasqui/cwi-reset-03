package br.com.cwi.reset.maiaraalegrevelasquihiller.service;


import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Filme;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Genero;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.PersonagemAtor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.repository.FilmeRepository;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Service
public class FilmeService {
     @Autowired
     private FilmeRepository filmeRepository;
     
     @Autowired
     private DiretorService diretorService;
     
     @Autowired
     private EstudioService estudioService;
     
     @Autowired
     private PersonagemAtorService personagemAtorService;

     public void criarFilme(FilmeRequest filmeRequest) throws Exception {
          final List<Filme> filmesCadastrados = (List<Filme>) filmeRepository.findAll();

          final Filme filme = new Filme(
                  ofNullable(filmeRequest.getNome()).orElseThrow(() -> new NomeNaoInformadoException()),
                  ofNullable(filmeRequest.getAnoLancamento()).orElseThrow(() -> new AnoLancamentoNaoInformadoException()),
                  ofNullable(filmeRequest.getCapaFilme()).orElseThrow(() -> new CapaFilmeNaoInformadaException()),
                  ofNullable(filmeRequest.getGeneros()).orElseThrow(() -> new GeneroNaoInformadoException()),
                  estudioService.consultarEstudio(filmeRequest.getIdEstudio()),
                  diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                  personagemAtorService.cadastrarPersonagensFilme(filmeRequest.getPersonagens()),
                  ofNullable(filmeRequest.getResumo()).orElseThrow(() -> new ResumoNaoInformadoException())
          );

          if (filme.getGeneros().isEmpty()) {
               throw new NenhumGeneroInformadoException("Deve ser informado pelo menos um gênero para o cadastro do filme.");
          }

          final Set<Genero> generoSet = new HashSet<>();

          for (Genero genero : filme.getGeneros()) {
               if (generoSet.contains(genero)) {
                    throw new GeneroRepetidoException("Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme.");
               } else {
                    generoSet.add(genero);
               }
          }

          filmeRepository.save(filme);
     }

     public List<Filme> consultarFilmes(
             String nomeFilme,
             String nomeDiretor,
             String nomePersonagem,
             String nomeAtor) throws Exception {
          final List<Filme> filmesCadastrados = (List<Filme>) filmeRepository.findAll();

          if (filmesCadastrados.isEmpty()) {
               throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
          }

          final List<Filme> filtrarNomePersonagem = filtrarNomePersonagem(filmesCadastrados, nomePersonagem);
          final List<Filme> filtrarNomeAtor = filtrarNomeAtor(filtrarNomePersonagem, nomeAtor);
          final List<Filme> filtrarNomeDiretor = filtrarNomeDiretor(filtrarNomeAtor, nomeDiretor);
          final List<Filme> filtroFinal = filtrarNomeFilme(filtrarNomeDiretor, nomeFilme);

          if (filtroFinal.isEmpty()) {
               throw new FilmeNaoEncontradoException(
                       String.format(
                               "Filme não encontrado com os filtros nomeFilme=%s, nomeDiretor=%s, nomePersonagem=%s, nomeAtor=%s, favor informar outros filtros.",
                               nomeFilme,
                               nomeDiretor,
                               nomePersonagem,
                               nomeAtor
                       )
               );
          }

          return filtroFinal;
     }

     private List<Filme> filtrarNomeFilme(final List<Filme> listaOriginal, final String nome) {
          if (isNull(nome)) {
               return listaOriginal;
          }

          final List<Filme> filmeFiltrado = new ArrayList<>();

          for (Filme filme : listaOriginal) {
               if (filme.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
               }
          }

          return filmeFiltrado;
     }

     private List<Filme> filtrarNomeDiretor(final List<Filme> listaOriginal, final String nome) {
          if (isNull(nome)) {
               return listaOriginal;
          }

          final List<Filme> filmeFiltrado = new ArrayList<>();

          for (Filme filme : listaOriginal) {
               if (filme.getDiretor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
               }
          }

          return filmeFiltrado;
     }

     private List<Filme> filtrarNomeAtor(final List<Filme> listaOriginal, final String nome) {
          if (isNull(nome)) {
               return listaOriginal;
          }

          final List<Filme> filmeFiltrado = new ArrayList<>();

          for (Filme filme : listaOriginal) {
               for (PersonagemAtor personagens : filme.getPersonagens()) {
                    if (personagens.getAtor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                         filmeFiltrado.add(filme);
                         break;
                    }
               }
          }

          return filmeFiltrado;
     }

     private List<Filme> filtrarNomePersonagem(final List<Filme> listaOriginal, final String nome) {
          if (isNull(nome)) {
               return listaOriginal;
          }

          final List<Filme> filmeFiltrado = new ArrayList<>();

          for (Filme filme : listaOriginal) {
               for (PersonagemAtor personagens : filme.getPersonagens()) {
                    if (personagens.getNomePersonagem()
                            .toLowerCase(Locale.ROOT)
                            .equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))
                    ) {
                         filmeFiltrado.add(filme);
                         break;
                    }
               }
          }

          return filmeFiltrado;
     }
}
