package br.com.cwi.reset.maiaraalegrevelasquihiller;

import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.dominio.StatusCarreira;
import br.com.cwi.reset.maiaraalegrevelasquihiller.erros.CampoObrigatorioException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.AtorRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.service.AtorService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
       AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

       try {
           atorService.criarAtor(atorRequest);
       } catch (CampoObrigatorioException e){
           System.out.println(e.getMessage());
       }


        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
    }
}