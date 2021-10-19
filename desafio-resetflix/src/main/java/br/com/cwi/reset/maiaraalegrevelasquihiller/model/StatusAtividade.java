package br.com.cwi.reset.maiaraalegrevelasquihiller.model;

public enum StatusAtividade {
    EM_ATIVIDADE("Em atividade."),
    ENCERRADO("Atividade encerradas.");

    private String descricao;

    StatusAtividade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
