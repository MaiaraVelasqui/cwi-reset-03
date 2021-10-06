public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 4;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public static void diminuirQtdeItem(String item, int qtde){
        if ("pao".equals(item)) {
            pao -= qtde;
        }
        if ("torta".equals(item)){
            torta -= qtde;
        }
        if("sanduiche".equals(item)){
            sanduiche -= qtde;
        }
        if("leite".equals(item)){
            leite -= qtde;
        }
        if("cafe".equals(item)){
            cafe -= qtde;
        }
    }
}
