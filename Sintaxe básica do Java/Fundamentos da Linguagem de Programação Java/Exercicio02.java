// Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área e exiba na tela

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do lado do quadrado");
        float lado = sc.nextFloat();
        float area = lado * lado;
        System.out.printf("A área do quadrado é %sm²", area);
    }
}
