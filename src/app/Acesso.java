package app;

import java.util.Stack;
import javax.swing.JOptionPane;

public class Acesso {
    private Stack<Cliente> clientes = new Stack<Cliente>();
    private String options[] = { "Login", "Cadastro" };
    private Cliente clienteLogin;

    public Acesso() {
    }

    public Stack<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Stack<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(Cliente clienteLogin) {
        this.clienteLogin = clienteLogin;
    }

    public Cliente login() {
        if (clientes.isEmpty()){
            String nome = JOptionPane.showInputDialog(null, "Digite seu nome", "Nome", JOptionPane.QUESTION_MESSAGE);
            if (nome == null) System.exit(0);
                
            String email = JOptionPane.showInputDialog(null, "Digite seu email", "Email", JOptionPane.QUESTION_MESSAGE);
            if (email == null) System.exit(0);

            String senha = JOptionPane.showInputDialog(null, "Digite sua senha", "Senha", JOptionPane.QUESTION_MESSAGE);
            if (senha == null) System.exit(0);

            Cliente c = new Cliente(nome, email, senha);
            clientes.push(c);

            return null;
        }

        int resposta = JOptionPane.showOptionDialog(null, "Você deseja efetuar um login ou um novo cadastro? ",
                "Acesso", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, -1);
        if (resposta == -1) System.exit(0);

        if (resposta == 0) {
            Cliente cLogin = null;
            String email = JOptionPane.showInputDialog(null, "Digite o email da conta",
                    "Login", JOptionPane.QUESTION_MESSAGE);
            if (email == null) System.exit(0);

            for (Cliente c : clientes) {
                if (email.equals(c.getEmail())) {
                    cLogin = c;
                    break;
                }
            }

            if (cLogin != null) {
                String senha = JOptionPane.showInputDialog(null, "Digite sua senha",
                        "Acesso", JOptionPane.QUESTION_MESSAGE);
                if (senha == null) System.exit(0);

                if (senha.equals(cLogin.getSenha())) {
                    return cLogin;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }  else {
                JOptionPane.showMessageDialog(null, "Email incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
                return null;
            }

        } else {
            String nome = JOptionPane.showInputDialog(null, "Digite seu nome", "Nome", JOptionPane.QUESTION_MESSAGE);
            if (nome == null) System.exit(0);
                
            String email = JOptionPane.showInputDialog(null, "Digite seu email", "Email", JOptionPane.QUESTION_MESSAGE);
            if (email == null) System.exit(0);

            String senha = JOptionPane.showInputDialog(null, "Digite sua senha", "Senha", JOptionPane.QUESTION_MESSAGE);
            if (senha == null) System.exit(0);

            Cliente c = new Cliente(nome, email, senha);
            clientes.push(c);

            return null;
        }
    }
}
