public class Ator {

    private String nome;
    private Integer idade;
    private Integer numeroOscars;
    private Genero genero;


    public void dadosPessoais(String nome, Integer idade, Genero genero){
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;

    }
    public Ator(String nome, Integer idade, Integer numeroOscars) {
        this.nome = nome;
        this.idade = idade;
        this.numeroOscars = numeroOscars;
        this.genero = genero;
    }
    public void imprimirInformacoes(){
        System.out.println("Nome:");
        System.out.println("Idade");
        System.out.println("Genero:" + genero.getDescricao());

    }
}
