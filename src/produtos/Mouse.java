package produtos;
public class Mouse extends Produto{
    String dpi;

    public Mouse(String nomeProduto, float valorDinheiro, float valorPonto, String dpi) {
        super(nomeProduto, valorDinheiro, valorPonto);
        this.dpi = dpi;
    }

    @Override
    public String toString() {
        return "Mouse " + getNomeProduto() + " // Custo em dinheiro: R$ " + getValorDinheiro() + " // Custo em Pontos: " + getValorPonto() + " // Quantidade de DPI: " + dpi;
    }

    
}
