package app;


public class Interface {
    private Cliente cliente;

    public Interface() {

        Acesso a = new Acesso();
        cliente = a.getClienteLogin();

        Loja l = new Loja();

        boolean resposta = true;

        while (resposta){
            resposta = l.novaCompra();
        }

        l.mostraCarrinho();

        l.concluirCompra(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
