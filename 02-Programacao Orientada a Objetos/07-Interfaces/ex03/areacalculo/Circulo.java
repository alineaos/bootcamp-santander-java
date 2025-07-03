package ex03.areacalculo;

public record Circulo (float raio) implements CalcularArea{
    private final static float pi = 3.14f;

    @Override
    public float calcularArea() {
        return pi * (raio * raio);
    }
}
