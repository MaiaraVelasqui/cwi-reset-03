package br.com.cwi.reset.maiaraalegrevelasquihiller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataCriacaoNaoInformadoException extends CampoNaoInformadoException {

    public DataCriacaoNaoInformadoException() {
        super("dataCriacao");
    }
}
