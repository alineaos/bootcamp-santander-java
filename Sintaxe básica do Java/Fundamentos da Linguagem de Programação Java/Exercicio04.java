// Escreva um código que receba o nome e a idade de 2 pessoas e imprima a diferença de idade entre elas

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        String nome01 = sc.next();
        System.out.println("Qual a sua idade?");
        int idade01 = sc.nextInt();

        System.out.println("Qual o seu nome?");
        String nome02 = sc.next();
        System.out.println("Qual a sua idade?");
        int idade02 = sc.nextInt();
        int diferenca = idade01 - idade02;

        System.out.printf("%s possui %s anos, e %s possui %s anos. A diferença de idade é de %s anos",nome01,idade01,nome02,idade02,Math.abs(diferenca));

    }
}
