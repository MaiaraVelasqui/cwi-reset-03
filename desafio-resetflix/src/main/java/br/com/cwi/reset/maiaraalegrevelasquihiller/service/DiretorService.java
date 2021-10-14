package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.AtorEmAtividade;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.StatusCarreira;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.CampoObrigatorioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.FiltroNaoEncontradoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.SemCadastroException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.DiretorRequest;

import java.util.ArrayList;
import java.util.List;

public class DiretorService {


     private FakeDatabase fakeDatabase;

     public DiretorService(FakeDatabase fakeDatabase) {
          this.fakeDatabase = fakeDatabase;
     }

     public void criarDiretor(DiretorRequest diretorRequest) throws CampoObrigatorioException {
          if (diretorRequest.getNome() == null || diretorRequest.getNome() == ""){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo nome.");
          }
          if (diretorRequest.getDataNascimento() == null){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo data de nascimento.");
          }
          if (diretorRequest.getAnoInicioAtividade() == null){
               throw new CampoObrigatorioException("Campo obrigatório não informado. Favor informar o campo ano início atividade.");
          }

          Diretor diretor = new Diretor(fakeDatabase.gerarId(),diretorRequest.getNome(),diretorRequest.getDataNascimento(),
                  diretorRequest.getAnoInicioAtividade());
          fakeDatabase.persisteDiretor(diretor);
     }

     public List<Diretor> listarDiretores(String filtroNome) throws SemCadastroException, FiltroNaoEncontradoException {
          List<Diretor> listaRetorno = new ArrayList<>();
          List<Diretor> diretores = fakeDatabase.recuperaDiretores();
          if (diretores.isEmpty()) {
               throw new SemCadastroException("Nenhum diretor cadastrado, favor cadastar diretores.");
          }
          for (Diretor diretor : diretores) {
               if (filtroNome != null){
                    if (diretor.getNome().contains(filtroNome)) {
                         listaRetorno.add(diretor);
                    }
               }else {
                    listaRetorno.add(diretor);
               }


          }

          if (filtroNome != null){
               if (listaRetorno.isEmpty()) {
                    throw new FiltroNaoEncontradoException("Diretor não encontrato com o filtro " +  filtroNome + " favor informar outro filtro.");
               }
          }
          return listaRetorno;
     }

     public Diretor consultarDiretor(Integer id) throws FiltroNaoEncontradoException {
          List<Diretor> diretores = fakeDatabase.recuperaDiretores();
          for (Diretor diretor : diretores) {
               if (diretor.getId() == id) {
                    return diretor;
               }
          }

          throw new FiltroNaoEncontradoException("Nenhum diretor encontrado com o parâmetro id= " + id + ", favor verifique os parâmetros informados.");
     }

}
