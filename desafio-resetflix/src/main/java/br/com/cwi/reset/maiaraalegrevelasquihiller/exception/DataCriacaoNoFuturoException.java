package br.com.cwi.reset.maiaraalegrevelasquihiller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataCriacaoNoFuturoException extends Exception {
    public DataCriacaoNoFuturoException() {
        super("Não é possível cadastrar estúdios do futuro.");
    }
}
