package br.com.cwi.reset.maiaraalegrevelasquihiller.exception;

public enum TipoDominioException {

    ATOR("ator", "atores"),
    DIRETOR("diretor", "diretores"),
    ESTUDIO("estudio","estudios"),
    FILME ("filme", "filmes");

    private final String singular;
    private final String plural;

    TipoDominioException(final String singular, final String plural) {
        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }
}
