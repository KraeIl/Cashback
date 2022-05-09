package app;
public class Produto {
    private String nomeProduto;
    private float valorDinheiro, valorPonto;
    
    public Produto(String nomeProduto, float valorDinheiro, float valorPonto) {
        this.nomeProduto = nomeProduto;
        this.valorDinheiro = valorDinheiro;
        this.valorPonto = valorPonto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getValorDinheiro() {
        return valorDinheiro;
    }

    public void setValorDinheiro(float valorDinheiro) {
        this.valorDinheiro = valorDinheiro;
    }

    public float getValorPonto() {
        return valorPonto;
    }

    public void setValorPonto(float valorPonto) {
        this.valorPonto = valorPonto;
    }

    @Override
    public String toString() {
        return "Produto [nomeProduto=" + nomeProduto + ", valorDinheiro=" + valorDinheiro + ", valorPonto=" + valorPonto
                + "]";
    }
    
    

    
}
