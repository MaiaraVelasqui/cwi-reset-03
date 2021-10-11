import java.time.LocalDate;

public class Ator  extends  Pessoa{


    private Integer numeroOscars;

    public Ator(){

    }
    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer numeroOscars) {
        super(nome, dataNascimento, genero);
        this.numeroOscars = numeroOscars;
    }

}
