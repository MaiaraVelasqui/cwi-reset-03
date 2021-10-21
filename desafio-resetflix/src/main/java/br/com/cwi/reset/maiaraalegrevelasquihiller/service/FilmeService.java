package br.com.cwi.reset.maiaraalegrevelasquihiller.service;


import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Filme;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.StatusCarreira;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.response.AtorEmAtividade;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.BasicInfoRequiredValidator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.validator.FilmeValidacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FilmeService {

     private FakeDatabase fakeDatabase;

     public FilmeService(FakeDatabase fakeDatabase) {
          this.fakeDatabase = fakeDatabase;
     }

     public void criarFilme(FilmeRequest filmeRequest) throws Exception {
          new FilmeValidacao().accept(filmeRequest);


//          final List<Filme> filmesCadastrados = fakeDatabase.recuperaAtores();
//
//          for (Ator atorCadastrado : atoresCadastrados) {
//               if (atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())) {
//                    throw new CadastroDuplicadoException(TipoDominioException.ATOR.getSingular(), atorRequest.getNome());
//               }
//          }
//
//          final Integer idGerado = atoresCadastrados.size() + 1;
//
//          final Ator ator = new Ator(idGerado, atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
//
//          fakeDatabase.persisteAtor(ator);
     }

     public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
          final List<Ator> atoresCadastrados = fakeDatabase.recuperaAtores();

          if (atoresCadastrados.isEmpty()) {
               throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
          }

          final List<AtorEmAtividade> retorno = new ArrayList<>();

          if (filtroNome != null) {
               for (Ator ator : atoresCadastrados) {
                    final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                    final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                    if (containsFilter && emAtividade) {
                         retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                    }
               }
          } else {
               for (Ator ator : atoresCadastrados) {
                    final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                    if (emAtividade) {
                         retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                    }
               }
          }

          if (retorno.isEmpty()) {
               throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
          }

          return retorno;
     }

     public Ator consultarAtor(Integer id) throws Exception {
          if (id == null) {
               throw new IdNaoInformado();
          }

          final List<Ator> atores = fakeDatabase.recuperaAtores();

          for (Ator ator : atores) {
               if (ator.getId().equals(id)) {
                    return ator;
               }
          }

          throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
     }

     public List<Ator> consultarAtores() throws Exception {
          final List<Ator> atores = fakeDatabase.recuperaAtores();

          if (atores.isEmpty()) {
               throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
          }

          return atores;
     }
}