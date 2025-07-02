import java.time.OffsetDateTime;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        int anoAtual = OffsetDateTime.now().getYear();
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        String nome = sc.next();
        System.out.println("Qual o seu ano de nascimento?");
        int anoNascimento = sc.nextInt();
        int idade = anoAtual - anoNascimento;
        System.out.printf("Olá %s, você tem %s anos.", nome, idade);
    }
}
