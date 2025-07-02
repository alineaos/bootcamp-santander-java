import java.util.Scanner;

public class Ex01Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro para ver a sua tabuada: ");
        int numero = sc.nextInt();

        System.out.printf("\nTabuada do %d", numero);

        for (int i = 1;i <= 10;i++){
            int multiplicacao = numero * i;
            System.out.printf("\n %d X %d = %d", i, numero, multiplicacao);
        }
    }


}
