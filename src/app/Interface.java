package app;


public class Interface {
    private Cliente cliente;
    private Acesso a;

    public Interface() {

        a = new Acesso();
        iniciar();
    }

    public void iniciar(){

        a.login();

        cliente = a.getClienteLogin();

        Loja l = new Loja();

        boolean resposta = true;

        while (resposta){
            resposta = l.novaCompra();
        }

        l.mostraCarrinho();

        l.concluirCompra(cliente, this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
