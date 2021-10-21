package br.com.cwi.reset.maiaraalegrevelasquihiller.validator;

import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.FilmeRequest;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.PersonagemRequest;

import java.time.LocalDate;

public class FilmeValidacao {

    public void accept(FilmeRequest filmeRequest) throws Exception {
        if (filmeRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }
        if (filmeRequest.getAnoLancamento() == null) {
            throw new AnoLancamentoNaoInformadoException();
        }
        if (filmeRequest.getCapaFilme() == null) {
            throw new CapaFilmeNaoInformadoException();
        }
        if (filmeRequest.getGeneros() == null) {
            throw new GeneroNaoInformadoException();
        }
        if (filmeRequest.getIdEstudio() == null) {
            throw new IdNaoInformado();
        }
        if (filmeRequest.getIdDiretor() == null) {
            throw new IdNaoInformado();
        }
        if (filmeRequest.getResumo() == null) {
            throw new ResumoNaoInformadoException();
        }
        if (filmeRequest.getPersonagens() == null) {
            throw new PersonagemNaoInformadoException();

        }

        for (PersonagemRequest personagemRequest : filmeRequest.getPersonagens()) {
            new PersonagemValidacao().accept(personagemRequest);
        }
    }
}
