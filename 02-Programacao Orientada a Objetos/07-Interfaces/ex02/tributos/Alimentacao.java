package ex02.tributos;

public record Alimentacao(double valor) implements Tributo{
    private final static double taxa = 0.01;

    @Override
    public double tributar() {
        return valor + (valor * taxa);
    }
}
