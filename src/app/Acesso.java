package app;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Acesso {
    private Stack<Cliente> clientes = new Stack<Cliente>();
    private String options[] = {"Login", "Cadastro"};
    private Cliente clienteLogin;

    public Acesso() {
        if (clientes.empty()){
            String nome = JOptionPane.showInputDialog(null, "Digite seu nome", "Nome", JOptionPane.QUESTION_MESSAGE);
            String email = JOptionPane.showInputDialog(null, "Digite seu email", "Email", JOptionPane.QUESTION_MESSAGE);
            String senha = JOptionPane.showInputDialog(null, "Digite sua senha", "Senha", JOptionPane.QUESTION_MESSAGE);
            
            Cliente c = new Cliente(nome, email, senha);
            clientes.push(c);
        }

        int resposta = JOptionPane.showOptionDialog(null, "Você deseja efetuar um login ou um novo cadastro? ", "Acesso", JOptionPane.YES_NO_OPTION, 
                                     JOptionPane.QUESTION_MESSAGE, null, options, null);
        if (resposta == 0){
            login();
        } else {
            novoCadastro();
        }
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

    public void login(){
        Cliente cLogin = null;
        String email = JOptionPane.showInputDialog(null, "Digite o email da conta", 
                                                    "Login", JOptionPane.QUESTION_MESSAGE);

        for (Cliente c: clientes){
            if (email.equals(c.getEmail())){
                cLogin = c; 
            } else {
                JOptionPane.showMessageDialog(null, "Email incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
                login();
            }
            break;
        }

        if (cLogin != null){
            String senha = JOptionPane.showInputDialog(null, "Digite sua senha", 
                                        "Acesso", JOptionPane.QUESTION_MESSAGE);
            if (senha.equals(cLogin.getSenha())){
                clienteLogin = cLogin;
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta", "ERRO", JOptionPane.ERROR_MESSAGE);
                login();
            }
        }
    }

    public void novoCadastro(){
        String nome = JOptionPane.showInputDialog(null, "Digite seu nome", "Nome", JOptionPane.QUESTION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Digite seu email", "Email", JOptionPane.QUESTION_MESSAGE);
        String senha = JOptionPane.showInputDialog(null, "Digite sua senha", "Senha", JOptionPane.QUESTION_MESSAGE);
            
        Cliente c = new Cliente(nome, email, senha);
        clientes.push(c);

        int resposta = JOptionPane.showOptionDialog(null, "Você deseja efetuar um login ou um novo cadastro? ", "Acesso", JOptionPane.YES_NO_OPTION, 
                                     JOptionPane.QUESTION_MESSAGE, null, options, null);
        if (resposta == 0){
            login();
        } else {
            novoCadastro();
        }
    }

    
}
