import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inicial: ");
        int inicioNum = sc.nextInt();
        System.out.println("Só tem um jeito de finalizar o programa, você conseguirá?");
        System.out.println("Digite outros números até o programa encerrar");
        int num;
        do {
            num = sc.nextInt();
        } while (num % inicioNum != 0 || inicioNum > num);
    }
}
