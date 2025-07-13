package ex02.pesquisa.palavras;

import ex03.ordenacao.eventos.Evento;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        contagemMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if(!contagemMap.isEmpty()) {
            contagemMap.remove(palavra);
        }
    }

    public void exibirContagemPalavra(){
        System.out.println(contagemMap);
    }

    public String encontrarPalavraMaisFrequente(){
        int contagem = Integer.MIN_VALUE;
        String palavraFrequente = null;
        if(!contagemMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
                if (entry.getValue() > contagem) {
                    palavraFrequente = entry.getKey();
                    contagem = entry.getValue();
                }
            }
        }
        return palavraFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras palavras = new ContagemPalavras();

        palavras.adicionarPalavra("Palavra 1",5);
        palavras.adicionarPalavra("Palavra 2",3);
        palavras.adicionarPalavra("Palavra 3",9);
        palavras.adicionarPalavra("Palavra 4",6);

        palavras.removerPalavra("Palavra 4");
        palavras.exibirContagemPalavra();
        System.out.println(palavras.encontrarPalavraMaisFrequente());
    }
}
