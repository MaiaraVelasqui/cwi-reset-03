package br.com.cwi.reset.maiaraalegrevelasquihiller.service;


import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.response.AtorEmAtividade;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.BasicInfoRequiredValidator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.FilmeValidacao;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FilmeService {

     private FakeDatabase fakeDatabase;
     private EstudioService estudioService;
     private DiretorService diretorService;


     public FilmeService(FakeDatabase fakeDatabase) {
          this.fakeDatabase = fakeDatabase;
          this.estudioService = new EstudioService(fakeDatabase);
     }

     public void criarFilme(FilmeRequest filmeRequest) throws Exception {
          new FilmeValidacao().accept(filmeRequest);

          Estudio estudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());
          Diretor diretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());


          public List<Filme> listarFilmes(final String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {
               final List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();

               if (filmesCadastrados.isEmpty()) {
                    throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
               }

               final List<Filme> retorno = new ArrayList<>();

               if (filtroNome != null) {
                    for (Filme filme : filmesCadastrados) {
                         final boolean containsFilter = filme.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                         if (containsFilter) {
                              retorno.add(filme);
                         }
                    }
               } else {
                    retorno.addAll(diretoresCadastrados);
               }

               if (retorno.isEmpty()) {
                    throw new FiltroNomeNaoEncontrado("Diretor", filtroNome);
               }

               return retorno;
          }
     }



//     public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
//          final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();
//
//          if (atoresCadastrados.isEmpty()) {
//               throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
//          }
//
//          final List<AtorEmAtividade> retorno = new ArrayList<>();
//
//          if (filtroNome != null) {
//               for (Ator ator : atoresCadastrados) {
//                    final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
//                    final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
//                    if (containsFilter && emAtividade) {
//                         retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
//                    }
//               }
//          } else {
//               for (Ator ator : atoresCadastrados) {
//                    final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
//                    if (emAtividade) {
//                         retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
//                    }
//               }
//          }
//
//          if (retorno.isEmpty()) {
//               throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
//          }
//
//          return retorno;
     }
//
//     public Ator consultarAtor(Integer id) throws Exception {
//          if (id == null) {
//               throw new IdNaoInformado();
//          }
//
//          final List<Ator> atores = fakeDatabase.recuperaAtores();
//
//          for (Ator ator : atores) {
//               if (ator.getId().equals(id)) {
//                    return ator;
//               }
//          }
//
//          throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
//     }
//
//     public List<Ator> consultarAtores() throws Exception {
//          final List<Ator> atores = fakeDatabase.recuperaAtores();
//
//          if (atores.isEmpty()) {
//               throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
//          }
//
//          return atores;
//     }

