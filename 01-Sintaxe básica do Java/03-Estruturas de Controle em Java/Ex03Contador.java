import java.util.Scanner;

public class Ex03Contador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int num01 = sc.nextInt();
        System.out.println("Agora digite outro número maior que o anterior: ");
        int num02 = sc.nextInt();

        System.out.println("Escolha o intervalo desejado para realizar a contagem (par/impar)");
        String escolha = sc.next().toLowerCase();

        for (int i = num02; i >= num01 ; i--) {
            if (escolha.equals("par") && i % 2 == 0){
                System.out.println(i);
            } else if (escolha.equals("impar") && i % 2 == 1) {
                System.out.println(i);
            }
        }

    }
}
