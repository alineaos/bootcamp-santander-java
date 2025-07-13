package ex02.pesquisa.numeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.listaNumeros.add(numero);
    }
    public int calcularSoma(){
        int soma = 0;
        for(Integer i : listaNumeros){
            soma+= i;
        }
        return soma;
    }
    public int encontrarMaiorNumero(){
        int maiorNumero = Integer.MIN_VALUE;
        if(!listaNumeros.isEmpty()) {
            for (Integer i : listaNumeros) {
                if (i > maiorNumero) {
                    maiorNumero = i;
                }
            }
        } else {
            throw new RuntimeException("Lista vazia.");
        }
            return maiorNumero;

    }

    public int encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
        if (!listaNumeros.isEmpty()) {
            for (Integer i : listaNumeros) {
                if (i < menorNumero) {
                    menorNumero = i;
                }
            }
        } else {
            throw new RuntimeException("Lista vazia.");
        }
        return menorNumero;
    }
    public void exibirNumeros(){
        System.out.println(listaNumeros);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(4);

        System.out.println("O maior número é: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("O menor número é: " + somaNumeros.encontrarMenorNumero());

        somaNumeros.exibirNumeros();
    }
}
