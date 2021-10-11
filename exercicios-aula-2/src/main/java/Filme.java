public class Filme {

    private String nome;

    private String descricao;

    private Integer duracao;

    private Integer anoLancamento;

    private Double avaliacao;

    private Diretor diretor;


    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {

        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;

        if (avaliacao < 1 || avaliacao > 5){
            throw new AvaliacaoForaDoPadraoException();
        }
    }


    public void reproduzir() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracao);
        System.out.println("Ano de lançamento " + anoLancamento);
        System.out.println("Avaliação " + avaliacao);
        System.out.println("Diretor: " + diretor.getNome());

    }


}
