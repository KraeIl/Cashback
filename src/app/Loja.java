package app;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Loja {
    private Stack<Produto> estoque;
    private Stack<Produto> carrinho;
    private JComboBox optionList;
    private JComboBox carrinhoList;
    private String[] options = { "Sim", "Não" };

    public Loja() {
        estoque = new Stack<Produto>();
        carrinho = new Stack<Produto>();

        Produto m1 = new Mouse("Razer Deathadder", 300.00f, 3000.00f, "11000");
        Produto m2 = new Mouse("Logitech gPro", 520.00f, 5200.00f, "25600");
        Produto m3 = new Mouse("Hyperx Pulsefire", 175.00f, 1750.00f, "11000");

        estoque.push(m1);
        estoque.push(m2);
        estoque.push(m3);

        Produto t1 = new Teclado("Hyperx MarsRGB", 300.00f, 3000.00f, "Outemu blue");
        Produto t2 = new Teclado("Razer Blackwidow", 600.00f, 6000.00f, "Razer green");
        Produto t3 = new Teclado("Corsair K100", 1100.00f, 11000.00f, "Corsair OPX");

        estoque.push(t1);
        estoque.push(t2);
        estoque.push(t3);

        Produto h1 = new Headset("GFallen Pro", 460.00f, 4600.00f, "7.1 Surround");
        Produto h2 = new Headset("Hyperx Cloud Stinger", 200.00f, 2000.00f, "Surround");
        Produto h3 = new Headset("Senheiser HD800S", 9499.05f, 94990.50f, "7.1 Surround");

        estoque.push(h1);
        estoque.push(h2);
        estoque.push(h3);

        Produto Celso = new Teclado("Celso Portiolli", 1000000.00f, 10000000.00f, "Switch SBT");
        estoque.push(Celso);

        optionList = new JComboBox(estoque);
        optionList.addItem("Selecione um item da loja");
        optionList.addItem("Sair do programa");
    }

    public void venda() {

        boolean continuar = true;

        while (continuar) {
            optionList.setSelectedIndex(estoque.size() - 2);

            JOptionPane.showMessageDialog(null, optionList, "Loja", JOptionPane.PLAIN_MESSAGE);
            if (optionList.getSelectedItem() == "Sair do programa")
                System.exit(0);

            try {
                carrinho.add((Produto) optionList.getSelectedItem());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Opção invalida", "Loja", JOptionPane.ERROR_MESSAGE);
            }

            int resposta = JOptionPane.showOptionDialog(null, "Adicionar mais um item? ", "Loja",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, -1);

            if (resposta == 0) {
                continuar = true;
            } else if (resposta == -1) {
                System.exit(0);
                continuar = true;
            } else {
                continuar = false;
            }
        }
    }

    public boolean mostraCarrinho() {
        int resposta = JOptionPane.showOptionDialog(null, "Deseja remover um item do carrinho? ", "Carrinho",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, -1);

        if (resposta == 0) {
            carrinhoList = new JComboBox(carrinho);
            carrinhoList.addItem("Selecione um item da lista");
            carrinhoList.addItem("Sair do programa");
            carrinhoList.setSelectedIndex(carrinho.size() - 2);

            while (resposta == 0) {
                JOptionPane.showMessageDialog(null, carrinhoList, "Carrinho", JOptionPane.PLAIN_MESSAGE);

                Produto p = (Produto) carrinhoList.getSelectedItem();

                if (p.equals("Selecione um item da lista")) {
                    JOptionPane.showMessageDialog(null, "Opção Invalida, retornando para o carrinho!! ", "ERRO!!",
                            JOptionPane.WARNING_MESSAGE);

                } else if (p.equals("Sair do programa")) {
                    System.exit(0);

                } else {
                    carrinho.remove(p);

                    resposta = JOptionPane.showOptionDialog(null, "Remover mais um item? ", "Carrinho",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

                    if (carrinho.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Carrinho está vázio, retornando para a loja",
                                "Carrinho vazio",
                                JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
            }

            carrinho.pop();
            carrinho.pop();
            return true;
        } else if (resposta == -1) {
            System.exit(0);
            return true;

        } else {
            return true;
        }
    }

    public boolean concluirCompra(Cliente c) {

        if (carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carrinho vazio!!!!", "ERRO!!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        if (c.getPontos() == 0) {
            float valorDinheiro = 0;
            float pontosGanhos;

            for (Produto p : carrinho) {
                valorDinheiro += p.getValorDinheiro();
            }

            pontosGanhos = valorDinheiro * 0.1f;
            JOptionPane.showMessageDialog(null,
                    "O valor total da compra foi de R$" + valorDinheiro + " e você ganhará " + pontosGanhos + " pontos",
                    "Pagamento", JOptionPane.INFORMATION_MESSAGE);
            c.addPontos(pontosGanhos);

            JOptionPane.showMessageDialog(null, "Você atualmente tem " + c.getPontos() + " pontos",
                    "Pontos", JOptionPane.INFORMATION_MESSAGE);

            return true;

        } else {

            String options[] = { "Dinheiro", "Ponto", "Pontos + Dinheiro" };
            int resposta = JOptionPane.showOptionDialog(null, "Como você deseja pagar? ",
                    "Acesso", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, null);

            if (resposta == 0) {
                float valorDinheiro = 0;
                float pontosGanhos;

                for (Produto p : carrinho) {
                    valorDinheiro += ((Produto) p).getValorDinheiro();
                }

                pontosGanhos = valorDinheiro * 0.1f;

                JOptionPane.showMessageDialog(null,
                        "O valor total da compra foi de R$" + valorDinheiro + " e você ganhará " + pontosGanhos
                                + " pontos",
                        "Pagamento", JOptionPane.INFORMATION_MESSAGE);
                c.addPontos(pontosGanhos);

                JOptionPane.showMessageDialog(null, "Você atualmente tem " + c.getPontos() + " pontos",
                        "Pontos", JOptionPane.INFORMATION_MESSAGE);

                return true;

            } else if (resposta == 1) {
                float valorPonto = 0;

                for (Produto p : carrinho) {
                    valorPonto += ((Produto) p).getValorPonto();
                }

                if (!(c.getPontos() < valorPonto)) {
                    JOptionPane.showMessageDialog(null,
                            "O valor total da compra foi de " + valorPonto + " pontos",
                            "Pagamento", JOptionPane.INFORMATION_MESSAGE);
                    c.addPontos(valorPonto * -1);

                    JOptionPane.showMessageDialog(null, "Você atualmente tem " + c.getPontos() + " pontos",
                            "Pontos", JOptionPane.INFORMATION_MESSAGE);

                    return true;

                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade de pontos insuficiente", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else if (resposta == 2) {
                float valorPonto = 0;
                float valorDinheiro = 0;

                for (Produto p : carrinho) {
                    valorPonto += ((Produto) p).getValorPonto();
                    valorDinheiro += ((Produto) p).getValorDinheiro();
                }

                valorDinheiro = valorDinheiro / 2;
                valorPonto = valorPonto / 2;

                if (!(c.getPontos() < valorPonto)) {
                    JOptionPane.showMessageDialog(null,
                            "O valor total da compra foi de R$" + valorDinheiro + " e também custará " + valorPonto
                                    + " pontos",
                            "Pagamento", JOptionPane.INFORMATION_MESSAGE);
                    c.addPontos(valorPonto * -1);

                    JOptionPane.showMessageDialog(null, "Você atualmente tem " + c.getPontos() + " pontos",
                            "Pontos", JOptionPane.INFORMATION_MESSAGE);

                    return true;

                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade de pontos insuficiente", "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }

            } else {
                return false;
            }

        }

    }
}
