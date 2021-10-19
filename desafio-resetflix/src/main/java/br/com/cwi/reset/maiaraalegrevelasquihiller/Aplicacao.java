package br.com.cwi.reset.maiaraalegrevelasquihiller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) {
        SpringApplication.run(Aplicacao.class, args);
    }
}




















/*public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
       AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

       AtorRequest atorRequest1 = new AtorRequest("Joseph Jason Momoa",LocalDate.of(1979, 8,1),StatusCarreira.EM_ATIVIDADE,1999);
       AtorRequest atorRequest2 = new AtorRequest("Emilia Isobel Clarke", LocalDate.of(1986,10,23),StatusCarreira.EM_ATIVIDADE,2011);
       AtorRequest atorRequest3 = new AtorRequest("Antonio de Carvalho Barbosa", LocalDate.of(1948,8,25),StatusCarreira.APOSENTADO, 1977);
       AtorRequest atorRequest4 = new AtorRequest("Charles CHaplin", LocalDate.of(1889, 4,16),StatusCarreira.APOSENTADO, 1914);


        DiretorRequest diretorRequest = new DiretorRequest("Steven Spielberg", LocalDate.of(1946,9,18),1971);
        DiretorRequest diretorRequest1 = new DiretorRequest("João Alfredo Santos", LocalDate.of(1983,5,12),2010);
        DiretorRequest diretorRequest2 = new DiretorRequest("Ana Clara Fonseca", LocalDate.of(1991,3,28),2018);
        DiretorRequest diretorRequest3 = new DiretorRequest("Antonieta Nunes", LocalDate.of(1985, 7, 19), 2005);



       try {
           atorService.criarAtor(atorRequest);
           atorService.criarAtor(atorRequest1);
           atorService.criarAtor(atorRequest2);
           atorService.criarAtor(atorRequest3);
           atorService.criarAtor(atorRequest4);

           System.out.println(atorService.listarAtoresEmAtividade("omoa"));

           diretorService.criarDiretor(diretorRequest);
           diretorService.criarDiretor(diretorRequest1);
           diretorService.criarDiretor(diretorRequest2);
           diretorService.criarDiretor(diretorRequest3);

           System.out.println(diretorService.listarDiretores(null));
           System.out.println(diretorService.listarDiretores("ao"));
       } catch (CampoObrigatorioException | SemCadastroException | FiltroNaoEncontradoException e){
           System.out.println(e.getMessage());
       }


        List<Ator> atores = fakeDatabase.recuperaAtores();
       List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println("Deve conter 5 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        System.out.println("Deve conter 4 diretor, quantidade encontrada: " + diretores.size());
        System.out.println("O primeiro diretor deve ser ' Steven Spielberg', valor encontrado: " + diretores.get(0).getNome());


    }
}*/