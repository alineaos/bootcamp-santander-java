package ex02.usuarios;

public class Atendente extends Usuario{
    private float valorCaixa;
    private float saldoInicial;

    public float getValorCaixa() {
        return valorCaixa;
    }

    public Atendente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void setAdministrador(boolean administrador) {
        super.setAdministrador(administrador);
        this.isAdministrador = false;
    }



    public void receberPagamentos(float valor){
        avisoConectar();
        if (this.isConectado) {
            valorCaixa += valor;
            System.out.println("Pagamento recebido com sucesso.");
        }
    }

    public void fecharCaixa(){
        avisoConectar();
        System.out.printf("Saldo inicial: R$%.2f || Saldo final: R$%.2f\n", this.saldoInicial, this.valorCaixa);
    }
}
