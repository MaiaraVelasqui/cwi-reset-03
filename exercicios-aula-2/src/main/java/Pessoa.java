public abstract class Pessoa {

    private String nome;
    private Integer idade;
    private Genero genero;

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }
    public void imprimirInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Genero: " + genero.getDescricao());

    }
    public String getNome(){
        return nome;
    }


}
