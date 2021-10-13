package br.com.cwi.reset.maiaraalegrevelasquihiller.dominio;

import java.time.LocalDate;

public class Pessoa {
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate anoInicioAtividade;

    public Pessoa(Integer id, String nome, LocalDate dataNascimento, LocalDate anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
