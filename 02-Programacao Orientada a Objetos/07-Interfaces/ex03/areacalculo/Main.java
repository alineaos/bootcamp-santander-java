package ex03.areacalculo;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        CalcularArea area = null;
        do {
        System.out.println("Escolha uma forma geométrica para calcular a sua área");
            System.out.println("[1] Quadrado");
            System.out.println("[2] Retangulo");
            System.out.println("[3] Circulo");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> area = areaQuadrado();
                case 2 -> area = areaRetangulo();
                case 3 -> area = areaCirculo();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }
            if (area != null) {
            System.out.println("O tamanho da área é " +area.calcularArea()+"cm².");
            }
        } while (true);

    }

    private static CalcularArea areaQuadrado(){
        System.out.println("Digite o tamanho dos lados: ");
        float lado = sc.nextFloat();
        return new Quadrado(lado);
    }

    private static CalcularArea areaRetangulo(){
        System.out.println("Digite o tamanho da base: ");
        float base = sc.nextFloat();
        System.out.println("Digite o tamanho da altura: ");
        float altura = sc.nextFloat();
        return new Retangulo(base, altura);
    }

    private static CalcularArea areaCirculo(){
        System.out.println("Digite o tamanho do raio: ");
        float raio = sc.nextFloat();
        return new Circulo(raio);
    }
}
