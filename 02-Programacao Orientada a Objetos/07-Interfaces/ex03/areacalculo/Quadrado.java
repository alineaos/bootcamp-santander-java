package ex03.areacalculo;

public record Quadrado(float lado) implements CalcularArea{

    @Override
    public float calcularArea() {
        return lado * lado;
    }

}
