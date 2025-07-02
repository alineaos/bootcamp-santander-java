package ex02.usuarios;

public class Vendedor extends Usuario{
    private int qtdeVendas;

    public int getQtdeVendas() {
        return qtdeVendas;
    }

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void setAdministrador(boolean administrador) {
        super.setAdministrador(administrador);
        this.isAdministrador = false;
    }



    public void realizarVendas(){
        avisoConectar();
        if (this.isConectado) {
            this.qtdeVendas++;
            System.out.println("Venda realizada com sucesso.");
        }
    }

    public void consultarVendas(){
        avisoConectar();
        System.out.println("Vendas realizadas: "+ this.qtdeVendas);
    }
}
