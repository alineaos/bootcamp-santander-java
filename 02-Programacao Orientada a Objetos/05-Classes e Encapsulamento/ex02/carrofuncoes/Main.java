package ex02.carrofuncoes;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static Carro carro = new Carro();
    public static void main(String[] args) {
       int opcao;
        do {
            System.out.println("\nEscolha uma opção");
            System.out.println("***********************");
            System.out.println("[1] Ligar o carro");
            System.out.println("[2] Desligar o carro");
            System.out.println("[3] Acelerar");
            System.out.println("[4] Desacelerar");
            System.out.println("[5] Virar para a esquerda");
            System.out.println("[6] Virar para a direita");
            System.out.println("[7] Verificar velocidade");
            System.out.println("[8] Próxima marcha");
            System.out.println("[9] Marcha anterior");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();
            if (!carro.isLigado() && opcao != 1 && opcao != 0) {
                System.out.println("Por favor, ligue o carro para continuar");
            } else {
                switch (opcao) {
                    case 1 -> carro.ligarCarro();
                    case 2 -> carro.desligarCarro();
                    case 3 -> carro.acelerar();
                    case 4 -> carro.desacelerar();
                    case 5 -> carro.virarEsquerda();
                    case 6 -> carro.virarDireita();
                    case 7 -> carro.verificarVelocidade();
                    case 8 -> carro.proximaMarcha();
                    case 9 -> carro.anteriorMarcha();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Opção inválida.");
                }
            }
        } while (true);
    }
}
