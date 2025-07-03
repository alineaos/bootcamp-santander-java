package ex02.tributos;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        Tributo tributo = null;
        double valor;
        do {
            System.out.println("Escolha um tipo de produto para calcular o valor após o tributo.");
            System.out.println("[1] Alimentação");
            System.out.println("[2] Saúde e Bem-estar");
            System.out.println("[3] Vestuário");
            System.out.println("[4] Cultura");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();
            System.out.println("Digite o valor do produto.");
            valor = sc.nextDouble();
            switch (opcao){
                case 1 -> tributo = alimentacao(valor);
                case 2 -> tributo = saudeBemEstar(valor);
                case 3 -> tributo = vestuario(valor);
                case 4 -> tributo = cultura(valor);
                case 5 -> System.exit(0);
            }
            if (tributo != null) {
                System.out.printf("Valor final: R$%.2f.\n", tributo.tributar());
            }
        } while (true);
    }

    private static Tributo alimentacao(double valor){
        return new Alimentacao(valor);
    }

    private static Tributo saudeBemEstar(double valor){
        return new SaudeBemEstar(valor);
    }

    private static Tributo vestuario(double valor){
        return new Vestuario(valor);
    }

    private static Tributo cultura(double valor){
        return new Cultura(valor);
    }
}
