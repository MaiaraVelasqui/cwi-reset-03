package br.com.cwi.reset.maiaraalegrevelasquihiller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Diretor;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.StatusCarreira;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.CampoObrigatorioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.DiretorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.AtorService;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.DiretorService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
       AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        DiretorRequest diretorRequest = new DiretorRequest("Steven Spielberg", LocalDate.of(1946,9,18),1971);




       try {
           atorService.criarAtor(atorRequest);
           diretorService.criarDiretor(diretorRequest);
       } catch (CampoObrigatorioException e){
           System.out.println(e.getMessage());
       }



        List<Ator> atores = fakeDatabase.recuperaAtores();
       List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        System.out.println("Deve conter 1 diretor, quantidade encontrada: " + diretores.size());
        System.out.println("O primeiro diretor deve ser ' Steven Spielberg', valor encontrado: " + diretores.get(0).getNome());
    }
}