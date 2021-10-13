package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.CampoObrigatorioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.DiretorRequest;

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

}
