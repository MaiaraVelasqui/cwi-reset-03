import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args){

        Diretor diretor = new Diretor ( "Cristopher Nollan", LocalDate.of(1980,5,22), Genero.MASCULINO,5);
        Diretor dire = new Diretor ("Maria Silva", LocalDate.of(1987,12,15), Genero.FEMININO, 18);
        diretor.imprimirInformacoes();
        Ator ator = new Ator("Teste", LocalDate.of(1956,9,6),Genero.FEMININO,10);
        ator.imprimirInformacoes();



       try {

           Filme interestelar = new Filme("Interestelar", "Muito bom", 120, 2014, 5.0, diretor);
           Filme nemo = new Filme("Procurando Nemo", "Um pai que procura seu filho", 90, 2006, 5.0,diretor);
           Filme diver = new Filme("Divertidamente", "Sentimentos e memórias",105, 2011,4.9,diretor);
           Filme avatar = new Filme("Avatar", "Ficção", 155, 2008, 4.6, dire);
           Filme gente = new Filme("Gente Grande", "Comédia", 93, 2002, 4.0,dire);

           List<Filme> filmes = new ArrayList<>();
           filmes.add(interestelar);
           filmes.add(nemo);
           filmes.add(diver);
           filmes.add(avatar);
           filmes.add(gente);

           for (Filme filme : filmes) {
               filme.reproduzir();

           }

       }catch (AvaliacaoForaDoPadraoException afdpe){

           System.out.println("Avaliação: inválida");
       }





    }
}
