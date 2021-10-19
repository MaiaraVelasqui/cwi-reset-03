package br.com.cwi.reset.maiaraalegrevelasquihiller.model;

public enum StatusCarreira {
    EM_ATIVIDADE ("Em atividade."),
    APOSENTADO ("Aposentado.");

    private String descricao;

    StatusCarreira(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
