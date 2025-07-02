package ex03.maquinapet;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static MaquinaPet maquinaPet = new MaquinaPet(30, 10, true);
    public static void main(String[] args) {
        int opcao ;
        do{
            System.out.println("\nEscolha uma opção");
            System.out.println("***********************");
            System.out.println("[1] Dar banho no pet");
            System.out.println("[2] Abastecer a máquina com água");
            System.out.println("[3] Abastecer a máquina com o shampoo");
            System.out.println("[4] Verificar nível da água");
            System.out.println("[5] Verificar nível do shampoo");
            System.out.println("[6] Verificar se tem pet no banho");
            System.out.println("[7] Colocar pet na máquina");
            System.out.println("[8] Retirar pet da máquina");
            System.out.println("[9] Limpar a máquina");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> maquinaPet.darBanho();
                case 2 -> maquinaPet.abastecerAgua();
                case 3 -> maquinaPet.abastecerShampoo();
                case 4 -> maquinaPet.verificarAgua();
                case 5 -> maquinaPet.verificarShampoo();
                case 6 -> checarDisponibilidadeMaquina();
                case 7 -> colocarPet();
                case 8 -> maquinaPet.retirarPet();
                case 9 -> maquinaPet.limparMaquina();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }
        } while (true);
    }

    public static void colocarPet(){
        if (!maquinaPet.getLimpo()){
            System.out.println("A máquina está suja. Limpe-a antes de colocar o pet.");
            return;
        }
        System.out.println("Informe o nome do pet");
        String nome = sc.next();
        Pet pet = new Pet(nome);
        maquinaPet.setPet(pet);
        System.out.printf("\nO pet %s foi colocado na máquina.", pet.getNome());
    }

    public static void checarDisponibilidadeMaquina(){
        var disponibilidade = maquinaPet.maquinaDisponivel();
        System.out.println(disponibilidade ? "Tem pet na máquina" : "Máquina disponível");
    }
}
