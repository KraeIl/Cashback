package app;


public class Interface {
    private Cliente cliente;
    private Acesso a;

    public Interface() {

        a = new Acesso();
        iniciar();
    }

    public void iniciar(){

        cliente = null;

        while (cliente == null){
            cliente = a.login();
        }
        

        Loja l = new Loja();

        boolean continuar = false;

        while (!continuar){
            l.venda();
            continuar = l.mostraCarrinho();
        }

        boolean finalizar = false;

        while (!finalizar){
            finalizar = l.concluirCompra(cliente);
        }
        
        iniciar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
