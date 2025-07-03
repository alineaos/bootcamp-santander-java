package ex02.tributos;

public record Cultura(double valor)  implements Tributo{
    private final static double taxa = 0.04;

    @Override
    public double tributar() {
        return valor + (valor * taxa);
    }
}
