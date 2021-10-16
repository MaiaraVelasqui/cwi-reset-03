package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Ator  extends  Pessoa{


    private Integer numeroOscars;

    public Integer getNumeroOscars() {
        return numeroOscars;
    }

    public void setNumeroOscars(Integer numeroOscars) {
        this.numeroOscars = numeroOscars;
    }

    public Ator(){

    }
    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer numeroOscars) {
        super(nome, dataNascimento, genero);
        this.numeroOscars = numeroOscars;
    }

}
