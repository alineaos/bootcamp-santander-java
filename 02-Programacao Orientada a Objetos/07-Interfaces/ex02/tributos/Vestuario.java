package ex02.tributos;

public record Vestuario(double valor) implements Tributo{
    private final static double taxa = 0.025;

    @Override
    public double tributar() {
        return valor + (valor * taxa);
    }
}
