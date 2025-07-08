package ex03.ordenacao.numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros{
    List<Integer> ordenacaoNumeros;

    public OrdenacaoNumeros() {
        this.ordenacaoNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.ordenacaoNumeros.add(numero);
    }

    public List <Integer> ordenarAscedente(){
        List<Integer> ordemAscedente = new ArrayList<>(this.ordenacaoNumeros);
        if (!ordenacaoNumeros.isEmpty()){
            Collections.sort(ordemAscedente);
            return ordemAscedente;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public List <Integer> ordenarDescendente(){
        List <Integer> ordemDescedente = new ArrayList<>(this.ordenacaoNumeros);
        if (!ordenacaoNumeros.isEmpty()){

            Collections.sort(ordemDescedente.reversed());
            return ordemDescedente;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenarnumeros = new OrdenacaoNumeros();

        ordenarnumeros.adicionarNumero(10);
        ordenarnumeros.adicionarNumero(6);
        ordenarnumeros.adicionarNumero(4);
        ordenarnumeros.adicionarNumero(1);
        ordenarnumeros.adicionarNumero(3);

        System.out.println(ordenarnumeros.ordenarAscedente());
        System.out.println(ordenarnumeros.ordenarDescendente());
    }
}
