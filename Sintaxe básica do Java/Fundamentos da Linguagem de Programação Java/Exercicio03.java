// Escreva um código que receba a base e a alturade um retângulo, calcule sua área e exiba na tela

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a base do retângulo");
        float base = sc.nextFloat();
        System.out.println("Digite a altura do retângulo");
        float altura = sc.nextFloat();
        float area = base * altura;
        System.out.printf("A área do retângulo é %sm²", area);
    }
}
