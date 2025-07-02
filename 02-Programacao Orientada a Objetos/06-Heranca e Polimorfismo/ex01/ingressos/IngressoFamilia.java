package ex01.ingressos;

public class IngressoFamilia extends Ingresso{
    private int clientes = 4;

    public int getClientes() {
        return clientes;
    }

    @Override
    public float valorFinal(Ingresso ingresso) {
        if (clientes > 3){
            this.valor *= clientes;
            this.valor -= this.valor * 0.05f;
        }
        return super.valorFinal(ingresso);
    }

    @Override
    public String toString() {
        return "Ingresso família - Filme: "+ nome + " || Idioma: "+ idioma +
                " || Clientes: " + clientes + " || Valor unitário: R$" + valor;
    }
}
