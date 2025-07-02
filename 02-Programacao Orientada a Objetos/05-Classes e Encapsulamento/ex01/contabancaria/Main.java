package ex01.contabancaria;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static ContaBancaria contaBancaria = new ContaBancaria();
    public static void main(String[] args) {
        int opcao;
        int valor;
        do {
            System.out.println("\nEscolha uma opção");
            System.out.println("***********************");
            System.out.println("[1] Consultar saldo");
            System.out.println("[2] Consultar Cheque Especial");
            System.out.println("[3] Depositar dinheiro");
            System.out.println("[4] Sacar dinheiro");
            System.out.println("[5] Pagar boleto");
            System.out.println("[6] Verificar uso do Cheque Especial");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    contaBancaria.consultarSaldo();
                    break;
                case 2:
                    contaBancaria.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.println("Digite o valor do depósito: ");
                    valor = sc.nextInt();
                    contaBancaria.depositarDinheiro(valor);
                    break;
                case 4:
                    System.out.println("Digite o valor do saque: ");
                    valor = sc.nextInt();
                    contaBancaria.sacarDinheiro(valor);
                    break;
                case 5:
                    System.out.println("Digite o valor do boleto: ");
                    valor = sc.nextInt();
                    contaBancaria.pagarBoleto(valor);
                    break;
                case 6:
                    contaBancaria.usandoChequeEspecial();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(true);
    }
}
