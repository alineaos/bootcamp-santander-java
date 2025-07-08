package ex01.operacoesbasicas.palavras;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavraSet;

    public ConjuntoPalavrasUnicas() {
        this.palavraSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavraSet.add(palavra);
    }
    public void removerPalavra(String palavra){
        String palavraParaRemover = null;
        for (String s : palavraSet){
            if (s.equalsIgnoreCase(palavra)){
                palavraParaRemover = s;
                break;
            }
        }

        if (palavraParaRemover != null) {
            palavraSet.remove(palavraParaRemover);
        } else {
            throw new RuntimeException("Palavra inválida.");
        }
    }
    public void verificarPalavra(String palavra){
        for (String s : palavraSet){
            if(s.equalsIgnoreCase(palavra)){
                System.out.printf("A palavra '%s' está presente no conjunto. \n", palavra);
                return;
            }
        }
        System.out.println("A palavra não está presente no conjunto");
    }
    public void exibirPalavrasUnicas(){
        System.out.println(palavraSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavras = new ConjuntoPalavrasUnicas();

        palavras.adicionarPalavra("Java");
        palavras.adicionarPalavra("POO");
        palavras.adicionarPalavra("Back-End");
        palavras.adicionarPalavra("Collections");
        palavras.adicionarPalavra("Classes");

        palavras.exibirPalavrasUnicas();
        palavras.removerPalavra("Poo");
        palavras.verificarPalavra("Poo");
        palavras.verificarPalavra("Java");
        palavras.exibirPalavrasUnicas();
    }
}

