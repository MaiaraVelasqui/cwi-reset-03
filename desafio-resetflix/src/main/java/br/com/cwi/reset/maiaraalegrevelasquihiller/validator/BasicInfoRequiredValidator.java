package br.com.cwi.reset.maiaraalegrevelasquihiller.validator;

import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;

import java.time.LocalDate;

public class BasicInfoRequiredValidator {

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade, final TipoDominioException tipoDominioException) throws Exception {

        if (nome.split(" ").length < 2) {
            throw new NomeSobrenomeObrigatorioException(tipoDominioException.getSingular());
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new AnoInicioAtividadeInvalidoException(tipoDominioException.getSingular());
        }
    }
}
