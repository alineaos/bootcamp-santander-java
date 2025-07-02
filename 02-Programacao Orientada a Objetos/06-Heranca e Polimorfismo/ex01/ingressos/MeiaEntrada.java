package ex01.ingressos;

public class MeiaEntrada extends Ingresso{

    @Override
    public float valorFinal(Ingresso ingresso) {
        this.valor = ingresso.getValor() / 2;
        return super.valorFinal(ingresso);
    }

    @Override
    public String toString() {
        return "Ingresso família - Filme: "+ nome + " || Idioma: "+ idioma;
    }
}
