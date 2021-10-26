package br.com.cwi.reset.maiaraalegrevelasquihiller.request;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.*;

import java.time.LocalDate;
import java.util.List;

public class FilmeRequest {
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Integer idEstudio;
    private Integer idDiretor;
    private String resumo;
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

