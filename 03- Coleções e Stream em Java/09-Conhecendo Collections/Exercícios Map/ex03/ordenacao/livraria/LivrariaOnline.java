package ex03.ordenacao.livraria;

import ex02.pesquisa.produtos.Produto;
import ex03.ordenacao.eventos.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LivrariaOnline {

    private Map<String, Livro> catalogo;

    public LivrariaOnline() {
        this.catalogo = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        catalogo.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        List<String> livroParaRemover = new ArrayList<>();
        if(!catalogo.isEmpty()) {
            for (Map.Entry<String, Livro> entry : catalogo.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    livroParaRemover.add(entry.getKey());
                }
            }
            for(String key : livroParaRemover) {
                catalogo.remove(key);
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
            List<Map.Entry<String, Livro>> livroParaOrdenarPreco = new ArrayList<>(catalogo.entrySet());
            Collections.sort(livroParaOrdenarPreco, new ComparatorPorPreco());
            Map<String, Livro> livroOrdenadoPreco = new LinkedHashMap<>();
        if(!catalogo.isEmpty()) {
            for (Map.Entry<String, Livro> entry: livroParaOrdenarPreco){
                livroOrdenadoPreco.put(entry.getKey(), entry.getValue());
            }
        }
        return livroOrdenadoPreco;
    }

    public Map<String, Livro> pesquisarLivroPorAutor(){
        List<Map.Entry<String, Livro>> livroParaOrdenarAutor = new ArrayList<>(catalogo.entrySet());
        Collections.sort(livroParaOrdenarAutor, new ComparatorPorAutor());
        Map<String, Livro> livroOrdenadoAutor = new LinkedHashMap<>();
        if(!catalogo.isEmpty()) {
            for (Map.Entry<String, Livro> entry: livroParaOrdenarAutor){
                livroOrdenadoAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livroOrdenadoAutor;
    }

    public Livro obterLivroMaisCaro(){
        Livro livroMaisCaro = null;
        double maisCaro = Double.MIN_VALUE;

        if(!catalogo.isEmpty()){
            for(Livro l : catalogo.values()){
                if (l.getPreco() > maisCaro){
                    livroMaisCaro = l;
                    maisCaro = l.getPreco();
                }
            }
        }
        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato(){
        Livro livroMaisBarato = null;
        double maisBarato = Double.MAX_VALUE;

        if(!catalogo.isEmpty()){
            for(Livro l : catalogo.values()){
                if (l.getPreco() < maisBarato){
                    livroMaisBarato = l;
                    maisBarato = l.getPreco();
                }
            }
        }
        return livroMaisBarato;
    }


    public static void main(String[] args) {
        LivrariaOnline catalogo = new LivrariaOnline();

        catalogo.adicionarLivro("https://a.co/d/6LxB4yT", "Entendendo Algoritmos", "Aditya Y. Bhargava", 55.90);
        catalogo.adicionarLivro("https://a.co/d/epaDBWA", "A revolução dos bichos", "George Orwell", 12.35);
        catalogo.adicionarLivro("https://a.co/d/2l4ELQs", "O homem mais rico da Babilônia", "George S Clason", 20.02);
        catalogo.adicionarLivro("https://a.co/d/dD1dsRw", "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 9.91);

        catalogo.removerLivro("o homem mais rico da Babilônia");
        System.out.println(catalogo.exibirLivrosOrdenadosPorPreco());
        System.out.println(catalogo.pesquisarLivroPorAutor());
        System.out.println(catalogo.obterLivroMaisCaro());
        System.out.println(catalogo.obterLivroMaisBarato());
    }
}
