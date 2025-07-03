package ex03.areacalculo;

public record Retangulo(float base, float altura) implements CalcularArea{

    @Override
    public float calcularArea() {
        return base * altura;
    }
}
