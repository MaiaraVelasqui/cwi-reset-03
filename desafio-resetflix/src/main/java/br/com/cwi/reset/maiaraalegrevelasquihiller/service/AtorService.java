package br.com.cwi.reset.maiaraalegrevelasquihiller.service;

import br.com.cwi.reset.maiaraalegrevelasquihiller.FakeDatabase;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.CampoObrigatorioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;

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

}
