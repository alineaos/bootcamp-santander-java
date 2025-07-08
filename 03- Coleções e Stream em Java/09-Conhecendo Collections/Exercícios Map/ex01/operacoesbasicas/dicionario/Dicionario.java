package ex01.operacoesbasicas.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public void adicionarPalavra(String palavra, String descricao){
        dicionarioMap.put(palavra, descricao);
    }

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void removerPalavra(String palavra){
       if (!dicionarioMap.isEmpty()) {
           dicionarioMap.remove(palavra);
       }
    }

    public void exibirPalavra(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra){
        String descricaoPorPalavra = null;
        if (!dicionarioMap.isEmpty()) {
            descricaoPorPalavra = dicionarioMap.get(palavra);
        }
        return descricaoPorPalavra;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Pessoa", "indivíduo considerado por si mesmo; ser humano, criatura.");
        dicionario.adicionarPalavra("Extravio", "desaparecimento, perda, sumiço.");
        dicionario.adicionarPalavra("Significado","Sentido de uma palavra, termo, frase; sentido, conceito.");
        dicionario.adicionarPalavra("Diligente","Que é zeloso, cuidadoso; repleto de diligência: médico diligente.");

        dicionario.removerPalavra("Extravio");
        dicionario.exibirPalavra();
        System.out.println(dicionario.pesquisarPorPalavra("Significado"));
    }
}
