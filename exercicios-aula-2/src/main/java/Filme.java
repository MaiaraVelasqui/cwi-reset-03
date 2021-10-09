public class Filme {

    private String nome;

    private String descricao;

    private Integer duracao;

    private Integer anoLancamento;

    private Double avaliacao;

    private Diretor diretor;


    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public Filme(String interestelar, String muito_bom, int duracao, int anoLancamento, int i) {
    }

    public Filme(String batman, String filme_muito_bom, int duracao, int anoLancamento, double avaliacao, Diretor diretor) {
    }

    public void reproduzir() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracao);
        System.out.println("Diretor: " + diretor.getNome());

    }


}
