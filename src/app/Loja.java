package app;
import java.util.Stack;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import produtos.Headset;
import produtos.Mouse;
import produtos.Produto;
import produtos.Teclado;

public class Loja {
    private Stack<Produto> estoque;
    private Carrinho pia;
    private JComboBox optionList;
    private JComboBox carrinhoList;
    private String[] options = {"Sim", "Não"};

    public Loja() {
        estoque = new Stack<Produto>();
        pia = new Carrinho();

        Mouse m1 = new Mouse("Razer Deathadder", 300.00f, 3000.00f, "11000");
        Mouse m2 = new Mouse("Logitech gPro", 520.00f, 5200.00f, "25600");
        Mouse m3 = new Mouse("Hyperx Pulsefire", 175.00f, 1750.00f, "11000");
        
        estoque.push(m1);
        estoque.push(m2);
        estoque.push(m3);

        Teclado t1 = new Teclado("Hyperx MarsRGB", 300.00f, 3000.00f, "Outemu blue");
        Teclado t2 = new Teclado("Razer Blackwidow", 600.00f, 6000.00f, "Razer green");
        Teclado t3 = new Teclado("Corsair K100", 1100.00f, 11000.00f, "Corsair OPX");

        estoque.push(t1);
        estoque.push(t2);
        estoque.push(t3);

        Headset h1 = new Headset("GFallen Pro", 460.00f, 4600.00f, "7.1 Surround");
        Headset h2 = new Headset("Hyperx Cloud Stinger", 200.00f, 2000.00f, "Surround");
        Headset h3 = new Headset("Senheiser HD800S", 9499.05f, 94990.50f, "7.1 Surround");

        estoque.push(h1);
        estoque.push(h2);
        estoque.push(h3);

        Teclado Celso = new Teclado("Celso Portiolli", 1000000.00f, 10000000.00f, "Switch SBT");
        estoque.push(Celso);

        optionList = new JComboBox(estoque);
        optionList.addItem("Selecione um item da loja");
        optionList.setSelectedIndex(estoque.size()-1);
    }

    public boolean novaCompra(){
        JOptionPane.showMessageDialog(null, optionList, "Loja", JOptionPane.PLAIN_MESSAGE);

        pia.addItem((Produto) optionList.getSelectedItem());

        int resposta = JOptionPane.showOptionDialog(null, "Adicionar mais um item? ", "Loja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        
        if (resposta == 0) return true;
        else return false;
    }

    public void mostraCarrinho(){
        int resposta = JOptionPane.showOptionDialog(null, "Deseja remover um item do carrinho? ", "Carrinho", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
        
        if (resposta == 0){
            carrinhoList = new JComboBox(pia.getPia());
            carrinhoList.addItem("Selecione um item do carrinho para remover");
            carrinhoList.setSelectedIndex(pia.getPia().size()-1);

            while(resposta == 0){
                JOptionPane.showMessageDialog(null, carrinhoList, "Carrinho", JOptionPane.PLAIN_MESSAGE);
                
                Produto item = (Produto) carrinhoList.getSelectedItem();
                pia.getPia().remove(item);
    
                resposta = JOptionPane.showOptionDialog(null, "Remover mais um item? ", "Carrinho", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            }
        }
    }

    public void concluirCompra(Cliente c){
        if (c.getPontos() == 0){
            float valorCompra = 0;
            float pontosGanhos;

            for (int i = 0; i < pia.getPia().size(); i++){
                valorCompra += pia.getPia().get(i).getValorDinheiro();
            }

            pontosGanhos = valorCompra*0.1f;
            JOptionPane.showMessageDialog(null, "O valor total da compra foi de R$" + valorCompra + " e você ganhará " + pontosGanhos + " pontos", 
                                            "Pagamento", JOptionPane.INFORMATION_MESSAGE);
            c.addPontos(pontosGanhos);


        }


    }
}
