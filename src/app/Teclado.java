package app;
public class Teclado extends Produto {
    
    String tipoSwitch;

    public Teclado(String nomeProduto, float valorDinheiro, float valorPonto, String tipoSwitch) {
        super(nomeProduto, valorDinheiro, valorPonto);
        this.tipoSwitch = tipoSwitch;
    }

    @Override
    public String toString() {
        return "Teclado " + getNomeProduto() + " // Custo em dinheiro: R$ " + getValorDinheiro() + " // Custo em Pontos: " + getValorPonto() + " // Tipo de Switch: " + tipoSwitch;
    }
}
