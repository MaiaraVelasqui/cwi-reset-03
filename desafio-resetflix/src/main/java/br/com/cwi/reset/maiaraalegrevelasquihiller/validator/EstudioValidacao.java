package br.com.cwi.reset.maiaraalegrevelasquihiller.validator;

import br.com.cwi.reset.maiaraalegrevelasquihiller.exception.*;
import br.com.cwi.reset.maiaraalegrevelasquihiller.request.EstudioRequest;

import java.time.LocalDate;

public class EstudioValidacao {

    public void accept(EstudioRequest estudioRequest) throws Exception {
        if (estudioRequest.getNome() == null) {
            throw new NomeNaoInformadoException();
        }

        if (estudioRequest.getDescricao() == null) {
            throw new DescricaoNaoInformadaException();
        }

        if (estudioRequest.getDataCriacao() == null) {
            throw new DataCriacaoNaoInformadoException();
        }

        if (estudioRequest.getStatusAtividade() == null) {
            throw new StatusNaoInformadoException();
        }


        if (LocalDate.now().isBefore(estudioRequest.getDataCriacao())) {
            throw new DataCriacaoNoFuturoException();
        }

    }
}
