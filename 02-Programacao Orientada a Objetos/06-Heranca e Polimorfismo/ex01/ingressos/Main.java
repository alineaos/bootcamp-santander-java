package ex01.ingressos;

public class Main {
    public static void main(String[] args) {
        MeiaEntrada meia = new MeiaEntrada();
        IngressoFamilia familia = new IngressoFamilia();
        System.out.println(familia);
        System.out.println("Valor total ingresso fámilia: R$"+familia.valorFinal(familia));
        System.out.println();
        System.out.println(meia);
        System.out.println("Valor do ingresso meia entrada: R$"+meia.valorFinal(meia));

    }
}
