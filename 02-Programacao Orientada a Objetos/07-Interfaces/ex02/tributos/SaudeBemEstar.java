package ex02.tributos;

public record SaudeBemEstar(double valor) implements Tributo{
    private final static double taxa = 0.015;

    @Override
    public double tributar() {
        return valor + (valor * taxa);
    }
}
