package app;
import java.util.Stack;

import produtos.Produto;

public class Carrinho {
    private Stack<Produto> pia;

    public Carrinho() {
        pia = new Stack<Produto>();
    }

    public Stack<Produto> getPia() {
        return pia;
    }

    public void setPia(Stack<Produto> pia) {
        this.pia = pia;
    }

    public void addItem(Produto item){
        pia.push(item);
    }

    @Override
    public String toString() {
        return "Itens no Carrinho = " + pia.toString();
    }

    
}
