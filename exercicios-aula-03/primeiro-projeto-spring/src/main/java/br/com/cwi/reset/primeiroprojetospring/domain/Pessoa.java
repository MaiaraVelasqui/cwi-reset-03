package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

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
