package br.com.cwi.reset.maiaraalegrevelasquihiller.validator;

import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.DescricaoNaoInformadaException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.IdNaoInformado;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.NomeNaoInformadoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.TipoAtuacaoNaoInformadoException;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.PersonagemRequest;

public class PersonagemValidacao {
    public void accept(PersonagemRequest personagemRequest) throws Exception {


        if (personagemRequest.getTipoAtuacao() == null) {
            throw new TipoAtuacaoNaoInformadoException();
        }

    }
}
