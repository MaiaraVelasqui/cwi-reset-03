import java.time.LocalDate;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;


    public Pessoa(){

    }
    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
    public void imprimirInformacoes(){
        System.out.println("Nome: " + nome);
        calcularIdade();
        System.out.println("Genero: " + genero.getDescricao());

    }
    private void calcularIdade(){
        int idade = 2021 - dataNascimento.getYear() ;
        System.out.println("Idade: " + idade);
    }
    public String getNome(){
        return nome;
    }


}
