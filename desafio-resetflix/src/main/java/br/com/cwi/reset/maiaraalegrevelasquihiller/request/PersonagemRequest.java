package br.com.cwi.reset.maiaraalegrevelasquihiller.request;

import br.com.cwi.reset.maiaraalegrevelasquihiller.model.Ator;
import br.com.cwi.reset.maiaraalegrevelasquihiller.model.TipoAtuacao;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;


public class PersonagemRequest {
    @NotNull(message = "Campo obrigatório não informado. Favor informar o idAtor.")
    private Integer idAtor;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o nome do personagem.")
    private String nomePersonagem;

    @NotNull(message = "Campo obrigatório não informado. Favor informar a descrição do personagem.")
    private String descricaoPersonagem;

    @NotNull(message = "Campo obrigatório não informado. Favor informar o tipo atuação.")
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest(Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonagemRequest that = (PersonagemRequest) o;
        return Objects.equals(idAtor, that.idAtor) && Objects.equals(nomePersonagem, that.nomePersonagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAtor, nomePersonagem);
    }
}

