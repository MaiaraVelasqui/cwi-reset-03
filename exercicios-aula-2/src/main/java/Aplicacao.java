public class Aplicacao {

    public static void main(String[] args){

        Diretor diretor = new Diretor( "Cristopher Nollan", 51, Genero.MASCULINO,5);
        diretor.imprimirInformacoes();
        Ator ator = new Ator("Teste", 80,Genero.FEMININO,10);
        ator.imprimirInformacoes();


       /*Filme interestelar = new Filme("Interestelar", "Muito bom", 120, 2014, 5);
        Filme batman = new Filme("Batman", "Filme muito bom", 120, 2011, 4.8, "Matt Rivers");*/


    }
}
