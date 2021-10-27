package br.com.cwi.reset.maiaraalegrevelasquihiller.request;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class FilmeRequest {
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome.")
    private String nome;

    @NotNull(message = "Ano lançamento não informado")
    private Integer anoLancamento;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo capaFilme.")
    private String capaFilme;

    @NotNull(message = "Campo obrigatório não informado. Favor informar os generos.")
    private List<Genero> generos;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o idEstudio .")
    private Integer idEstudio;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o idDiretor .")
    private Integer idDiretor;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o resumo .")
    private String resumo;

    @Valid
    @NotNull(message = "Campo obrigatório não informado. Favor informar os personagens.")
    private List<PersonagemRequest> personagens;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idEstudio, Integer idDiretor, String resumo, List<PersonagemRequest> personagens, Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idEstudio = idEstudio;
        this.idDiretor = idDiretor;
        this.resumo = resumo;
        this.personagens = personagens;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public Integer getIdDiretor() {
        return idDiretor;
    }

    public String getResumo() {
        return resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }

}

