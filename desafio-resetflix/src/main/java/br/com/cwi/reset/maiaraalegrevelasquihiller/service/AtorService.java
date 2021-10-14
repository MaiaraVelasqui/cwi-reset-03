package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.AtorEmAtividade;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.StatusCarreira;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.CampoObrigatorioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.FiltroNaoEncontradoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.SemCadastroException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;

import java.util.ArrayList;
import java.util.List;

public class AtorService {


     private FakeDatabase fakeDatabase;

     public AtorService(FakeDatabase fakeDatabase) {
          this.fakeDatabase = fakeDatabase;
     }

     public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioException {
          if (atorRequest.getNome() == null || atorRequest.getNome() == ""){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo nome.");
          }
          if (atorRequest.getDataNascimento() == null){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo data de nascimento.");
          }
          if (atorRequest.getStatusCarreira() == null){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo status carreira.");
          }
          if (atorRequest.getAnoInicioAtividade() == null){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo ano início atividade.");
          }

          Ator ator = new Ator(fakeDatabase.gerarId(),atorRequest.getNome(),atorRequest.getDataNascimento(),
                  atorRequest.getAnoInicioAtividade(),atorRequest.getStatusCarreira());
          fakeDatabase.persisteAtor(ator);
     }


     public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws SemCadastroException, FiltroNaoEncontradoException {
          List<AtorEmAtividade> atoresEmAtividade = new ArrayList<>();
          List<Ator> atores = fakeDatabase.recuperaAtores();
          if (atores.isEmpty()) {
               throw new SemCadastroException("Nenhum ator cadastrado, favor cadastar atores.");
          }
          for (Ator ator : atores) {
               if (StatusCarreira.EM_ATIVIDADE == ator.getStatusCarreira() ){
                    if (filtroNome != null){
                         if (ator.getNome().contains(filtroNome)) {
                              AtorEmAtividade atorEmAtividade = new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento());
                              atoresEmAtividade.add(atorEmAtividade);
                         }
                    }else {
                         AtorEmAtividade atorEmAtividade = new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento());
                         atoresEmAtividade.add(atorEmAtividade);
                    }
               }

          }

          if (filtroNome != null){
               if (atoresEmAtividade.isEmpty()) {
                    throw new FiltroNaoEncontradoException("Ator não encontrato com o filtro " +  filtroNome + " favor informar outro filtro.");
               }
          }
          return atoresEmAtividade;
     }
     public Ator consultarAtor(Integer id) throws FiltroNaoEncontradoException {
          List<Ator> atores = fakeDatabase.recuperaAtores();
          for (Ator ator : atores) {
               if (ator.getId() == id) {
                    return ator;
               }
          }

          throw new FiltroNaoEncontradoException("Nenhum ator encontrado com o parâmetro id= " + id + ", favor verifique os parâmetros informados.");
     }
     public List<Ator> consultarAtores() throws SemCadastroException {
          List<Ator> atores = fakeDatabase.recuperaAtores();
          if (atores.isEmpty()) {
               throw new SemCadastroException("Nenhum ator cadastrado, favor cadastar atores.");

          }
          return atores;
     }
}
