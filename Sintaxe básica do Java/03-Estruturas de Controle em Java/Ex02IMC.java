import java.util.Scanner;

public class Ex02IMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite sua altura em metros:");
        double altura = sc.nextDouble();
        System.out.print("Digite seu peso em quilogramas:");
        double peso = sc.nextDouble();
        double imc = peso/(altura * altura);
        System.out.printf("Seu IMC é %.1f. ", imc);
        if (imc <= 18.5){
            System.out.println("Você está abaixo do peso.");
        } else if (imc > 18.5 && imc < 25) {
            System.out.println("Você está no peso ideal.");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Você está levemente acima do peso");
        } else if (imc >= 30 && imc < 35) {
            System.out.println("Você está com obesidade Grau I");
        } else if (imc >= 35 && imc < 40) {
            System.out.println("Você está com obesidade Grau II (Severa)");
        } else {
            System.out.println("Você está com obesidade Grau III (Mórbida)");
        }

    }
}
