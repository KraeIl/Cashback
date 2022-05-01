package produtos;
public class Headset extends Produto{
    String tipoSound;

    public Headset(String nomeProduto, float valorDinheiro, float valorPonto, String tipoSound) {
        super(nomeProduto, valorDinheiro, valorPonto);
        this.tipoSound = tipoSound;
    }

    @Override
    public String toString() {
        return "Headset " + getNomeProduto() + " // Custo em dinheiro: R$ " + getValorDinheiro() + " // Custo em Pontos: " + getValorPonto() + " // Tipo de Som: " + tipoSound;
    }
}
